package vn.com.vuong.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vuong.entity.WareHouse;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {

	@Query("select wareHouse from WareHouse wareHouse where (:code = null or :code = '' or wareHouse.code = :code) and (:name = null or :name = '' or wareHouse.name like %:name%)")
	Page<WareHouse> search(@Param("code") String code, @Param("name") String name, Pageable pageable);

	Optional<WareHouse> findByCode(String code);

	Optional<WareHouse> findByName(String name);
}
