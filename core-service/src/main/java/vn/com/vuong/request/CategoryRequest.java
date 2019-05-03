package vn.com.vuong.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
	
	private String code;
	
	private String name;
	
	private Long categoryParentId;
}
