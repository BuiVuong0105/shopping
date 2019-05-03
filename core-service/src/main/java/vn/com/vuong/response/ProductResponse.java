package vn.com.vuong.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.Product;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
	@JsonInclude(Include.NON_NULL)
	private Long id;

	@JsonInclude(Include.NON_NULL)
	private String code;

	@JsonInclude(Include.NON_NULL)
	private String name;

	@JsonInclude(Include.NON_NULL)
	private String category;

	@JsonInclude(Include.NON_NULL)
	private Long categoryId;

	public ProductResponse(Product product) {
		this.setId(product.getId());
		this.setName(product.getName());
		this.setCode(product.getCode());
		this.setCategoryId(product.getCategoryId());
		this.setCategory(product.getCategoryName());
	}
}
