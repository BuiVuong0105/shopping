package vn.com.vuong.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.ItemSubType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {
	private String code;
	private String name;
	private Long itemSubTypeId;
	@JsonIgnore
	private ItemSubType itemSubType;
}
