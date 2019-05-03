package vn.com.vuong.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.WareHouse;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonInclude(Include.NON_NULL)
	private Long id;

	@JsonInclude(Include.NON_NULL)
	private String code;

	@JsonInclude(Include.NON_NULL)
	private String name;
	
	public WareHouseResponse(WareHouse wareHouse) {
		this.setId(wareHouse.getId());
		this.setName(wareHouse.getName());
		this.setCode(wareHouse.getCode());
	}
}
