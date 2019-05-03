package vn.com.vuong.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.ItemSubType;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemSubTypeResponse {
	@JsonInclude(Include.NON_NULL)
	private Long id;

	@JsonInclude(Include.NON_NULL)
	private String code;

	@JsonInclude(Include.NON_NULL)
	private String name;

	@JsonInclude(Include.NON_NULL)
	private String itemType;

	@JsonInclude(Include.NON_NULL)
	private Long itemTypeId;

	public ItemSubTypeResponse(ItemSubType itemSubType) {
		this.setId(itemSubType.getId());
		this.setName(itemSubType.getName());
		this.setCode(itemSubType.getCode());
		this.setItemTypeId(itemSubType.getItemTypeId());
		this.setItemType(itemSubType.getItemTypeName());
	}
}
