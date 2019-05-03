package vn.com.vuong.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.Item;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
	
	@JsonInclude(Include.NON_NULL)
	private Long id;

	@JsonInclude(Include.NON_NULL)
	private String code;

	@JsonInclude(Include.NON_NULL)
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	private String itemSubType;
	
	@JsonInclude(Include.NON_NULL)
	private Long itemSubTypeId;
	
	public ItemResponse(Item item) {
		this.setId(item.getId());
		this.setName(item.getName());
		this.setCode(item.getCode());
		this.setItemSubTypeId(item.getItemSubTypeId());
		this.setItemSubType(item.getItemSubTypeName());
	}
}
