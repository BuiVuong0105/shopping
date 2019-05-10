package vn.com.vuong.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.Menu;

@SuppressWarnings("serial")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse implements Serializable {
	
	private Long id;

	private String code;

	private String name;

	@JsonInclude(Include.NON_NULL)
	private Long parentId;

	@JsonInclude(Include.NON_NULL)
	private String parent;

	@JsonInclude(Include.NON_NULL)
	private List<MenuResponse> childrents;
	
	public MenuResponse(Menu menu) {
		this.setId(menu.getId());
		this.setCode(menu.getCode());
		this.setName(menu.getName());
		this.setParentId(menu.getParentId());
		String parent = menu.getParent() == null ? null : menu.getParent().getName();
		this.setParent(parent);
	}
}
