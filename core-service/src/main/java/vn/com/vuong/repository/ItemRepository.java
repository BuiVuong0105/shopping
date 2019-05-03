package vn.com.vuong.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vuong.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	@Query("select item from Item item where "
			+ "(:code = null or :code = '' or item.code = :code) "
			+ "and "
			+ "(:name = null or :name = '' or item.name like %:name%) "
			+ "and "
			+ "(:itemSubTypeId = null or item.itemSubType.id = :itemSubTypeId) "
			+ "")
	Page<Item> search(
			@Param("code")String code, 
			@Param("name")String name, 
			@Param("itemSubTypeId")Long itemSubTypeId, 
			Pageable pageable
			);
	
	Optional<Item> findByCode(String code);
	
	Optional<Item> findByName(String name);
	
}
