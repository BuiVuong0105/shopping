package vn.com.vuong.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vuong.entity.ItemSubType;


@Repository
public interface ItemSubTypeRepository extends JpaRepository<ItemSubType, Long> {
	
	@Query("select itemSubType from ItemSubType itemSubType where "
			+ "(:code = null or :code = '' or itemSubType.code = :code) "
			+ "and "
			+ "(:name = null or :name = '' or itemSubType.name like %:name%) "
			+ "and "
			+ "(:itemTypeId = null or itemSubType.itemTypeId = :itemTypeId)"
			)
	Page<ItemSubType> search(
			@Param("code")String code, 
			@Param("name")String name, 
			@Param("itemTypeId")Long itemTypeId, 
			Pageable pageable
			);
	
	Optional<ItemSubType> findByCode(String code);
	
	Optional<ItemSubType> findByName(String name);
}
