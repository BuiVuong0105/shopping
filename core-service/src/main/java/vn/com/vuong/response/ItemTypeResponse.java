package vn.com.vuong.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.ItemType;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemTypeResponse {

	@JsonInclude(Include.NON_NULL)
	private Long id;

	@JsonInclude(Include.NON_NULL)
	private String code;

	@JsonInclude(Include.NON_NULL)
	private String name;
	
	public ItemTypeResponse(ItemType itemType) {
		this.setId(itemType.getId());
		this.setName(itemType.getName());
		this.setCode(itemType.getCode());
	}
}
