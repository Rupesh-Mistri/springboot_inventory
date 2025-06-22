package com.inventory.entity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.entity.Purchase_details_model;

public interface Purchase_details_model_Repository extends JpaRepository<Purchase_details_model,Long> {
	List<Purchase_details_model> findByPurchase_Id(Long purchaseId);

	@Query(nativeQuery = true, value = "SELECT item.id as item_id, item_name, COALESCE(purchase_qty,0) as pur_qty, " +
            "COALESCE(sale_qty,0) as sale_qty, (COALESCE(purchase_qty,0) - COALESCE(sale_qty,0)) as avail " +
            "FROM tbl_item item " +
            "LEFT JOIN (SELECT tpd.item_id, SUM(quantity) AS purchase_qty FROM tbl_purchase_details tpd JOIN tbl_purchase tp ON tp.id = tpd.purchase_id where invoice_date between '2024-02-14' and  '2024-02-15'  GROUP BY item_id) pur " +
            "ON item.id = pur.item_id " +
            "LEFT JOIN (SELECT tsd.item_id, SUM(quantity) AS sale_qty FROM tbl_sale_details tsd  JOIN tbl_sale ts ON ts.id = tsd.sale_id where invoice_date between '2024-02-14' and  '2024-02-15'  GROUP BY item_id) sal " +
            "ON item.id = sal.item_id " +
            "WHERE item.status = 1 " +
            "GROUP BY item.id, item.item_name, purchase_qty, sale_qty")
    List<Object[]> getStockData();
    
    @Query(nativeQuery = true, value = "SELECT item.id as item_id, item_name, COALESCE(purchase_qty,0) as pur_qty, " +
            "COALESCE(sale_qty,0) as sale_qty, (COALESCE(purchase_qty,0) - COALESCE(sale_qty,0)) as avail " +
            "FROM tbl_item item " +
            "LEFT JOIN (SELECT tpd.item_id, SUM(quantity) AS purchase_qty FROM tbl_purchase_details tpd JOIN tbl_purchase tp ON tp.id = tpd.purchase_id WHERE tp.invoice_date BETWEEN :startDate AND :endDate GROUP BY item_id) pur " +
            "ON item.id = pur.item_id " +
            "LEFT JOIN (SELECT tsd.item_id, SUM(quantity) AS sale_qty FROM tbl_sale_details tsd JOIN tbl_sale ts ON ts.id = tsd.sale_id WHERE ts.invoice_date BETWEEN :startDate AND :endDate GROUP BY item_id) sal " +
            "ON item.id = sal.item_id " +
            "WHERE item.status = 1 " +
            "GROUP BY item.id, item.item_name, purchase_qty, sale_qty")
    List<Object[]> getStockPramData(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
