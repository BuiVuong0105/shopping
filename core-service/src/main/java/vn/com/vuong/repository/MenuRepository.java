package vn.com.vuong.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vuong.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	@Query("select m from Menu m where (:code = null or :code = '' or m.code = :code) and (:name = null or :name = '' or m.name like %:name%) and (:parentId = null or  m.parent.id = :parentId)")
	Page<Menu> search(@Param("code") String code, @Param("name") String name, @Param("parentId") Long parentId, Pageable pageable);

	@Query("select m from Menu m where m.parent.id is null")
	List<Menu> findRootMenu();

	Optional<Menu> findById(long id);

	Optional<Menu> findByName(String name);
	
	Optional<Menu> findByCode(String code);
}
