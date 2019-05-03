package vn.com.vuong.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.entity.Supplier;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonInclude(Include.NON_NULL)
	private Long id;

	@JsonInclude(Include.NON_NULL)
	private String code;

	@JsonInclude(Include.NON_NULL)
	private String name;
	
	public SupplierResponse(Supplier supplier) {
		this.setId(supplier.getId());
		this.setName(supplier.getName());
		this.setCode(supplier.getCode());
	}
}
