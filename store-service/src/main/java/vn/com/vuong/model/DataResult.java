package vn.com.vuong.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataResult<T> {
	
	@JsonInclude(Include.NON_NULL)
	private Integer page;
	
	@JsonInclude(Include.NON_NULL)
	private Integer pages;
	
	@JsonInclude(Include.NON_NULL)
	private Long records;

	@JsonInclude(Include.NON_NULL)
	private T data;
}
