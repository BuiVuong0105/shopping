package vn.com.vuong.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vuong.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select p from Product p where "
			+ "(:code = null or :code = '' or p.code = :code) "
			+ "and "
			+ "(:name = null or :name = '' or p.name like %:name%) "
			+ "and "
			+ "(:categoryId = null or p.category.id = :categoryId) "
			+ "")
	Page<Product> search(
			@Param("code")String code, 
			@Param("name")String name, 
			@Param("categoryId")Long categoryId, 
			Pageable pageable
			);
	
	Optional<Product> findByCode(String code);
	
	Optional<Product> findByName(String name);
}
