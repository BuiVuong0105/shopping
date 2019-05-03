package vn.com.vuong.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.Category;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String code;
	
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	private Long categoryParentId;
	
	@JsonInclude(Include.NON_NULL)
	private String categoryParentName;
	
	@JsonInclude(Include.NON_NULL)
	private List<CategoryResponse> categoryChildrents;
	
	public CategoryResponse(Category category) {
		this.setId(category.getId());
		this.setCode(category.getCode());
		this.setName(category.getName());
		this.setCategoryParentId(category.getCategoryParentId());
		String categoryParentName = category.getCategoryParent() == null ? null : category.getCategoryParent().getName();
		this.setCategoryParentName(categoryParentName);
	}
	
}
