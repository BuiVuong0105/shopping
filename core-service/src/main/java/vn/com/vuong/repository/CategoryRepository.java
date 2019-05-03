package vn.com.vuong.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vuong.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("select category from Category category where (:code = null or :code = '' or category.code = :code) and (:name = null or :name = '' or category.name like %:name%) and (:categoryParentId = null or  category.categoryParent.id = :categoryParentId)")
	Page<Category> search(@Param("code") String code, @Param("name") String name, @Param("categoryParentId") Long categoryParentId, Pageable pageable);

	@Query("select category from Category category where category.categoryParent.id = null")
	List<Category> findRootCategory();

	Optional<Category> findById(long id);

	Optional<Category> findByName(String name);
	
	Optional<Category> findByCode(String code);
}
