package vn.com.vuong.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
	private String code;
	private String name;
	private Long categoryId;
	@JsonIgnore
	private Category category;
}
