package vn.com.vuong.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchWareHouseRequest {
	private String code;
	private String name;
	private Integer order;
	private Integer page;
	private Integer size;
}
