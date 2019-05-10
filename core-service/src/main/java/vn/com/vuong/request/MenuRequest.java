package vn.com.vuong.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequest {
	
	private String code;
	
	private String name;
	
	private Long parentId;
}
