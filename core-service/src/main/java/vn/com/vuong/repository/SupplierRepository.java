package vn.com.vuong.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vuong.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	
	@Query("select s from Supplier s where (:code = null or :code = '' or s.code = :code) and (:name = null or :name = '' or s.name like %:name%)")
	Page<Supplier> search(@Param("code")String code, @Param("name")String name, Pageable pageable);
	
	Optional<Supplier> findByCode(String code);
	
	Optional<Supplier> findByName(String name);
	
	@Query("select s from Supplier s where s.name=:name or s.code=:code")
	Optional<Supplier> findByNameOrCode(@Param("name")String name, @Param("code")String code);
}
