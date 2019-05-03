package vn.com.vuong.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vuong.entity.ItemType;

@Repository
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
	
	@Query("select itemType from ItemType itemType where (:code = null or :code = '' or itemType.code = :code) and (:name = null or :name = '' or itemType.name like %:name%)")
	Page<ItemType> search(@Param("code")String code, @Param("name")String name, Pageable pageable);
	
	Optional<ItemType> findByCode(String code);
	
	Optional<ItemType> findByName(String name);
	
}
