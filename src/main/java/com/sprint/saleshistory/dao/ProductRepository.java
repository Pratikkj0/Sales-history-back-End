package com.sprint.saleshistory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sprint.saleshistory.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	List<ProductEntity> findByProdCategory(String category);

	List<ProductEntity> findByProdStatus(String status);

	List<ProductEntity> findByProdSubcategory(String subcategory);

	List<ProductEntity> findBySupplierId(int supplierId);

	List<ProductEntity> findByProdName(String prodName);

	@Query("Select p from ProductEntity p where p.prodName in (select p1.prodName from ProductEntity p1 group by p1.prodName having count(p1.prodName) > 1)")
	List<ProductEntity> findDuplicateProducts();

	@Query("SELECT p FROM ProductEntity p ORDER BY :field")
	List<ProductEntity> findProductsOrderByField(@Param("field") String field);

	@Query("SELECT c, p, cu FROM SalesEntity s JOIN s.channel c JOIN s.product p JOIN s.customer cu WHERE c.channelId = :channelId order by s.channel")
	public List<Object[]> findProductsByChannelWiseSold(@Param("channelId") int channelId);

}
