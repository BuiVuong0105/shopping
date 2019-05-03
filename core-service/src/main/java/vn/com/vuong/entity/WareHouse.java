package vn.com.vuong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.request.WareHouseRequest;

@SuppressWarnings("serial")
@Entity
@Table(name = "ware_house")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class WareHouse implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	public WareHouse(WareHouseRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
	}

	public void setValueFromRequest(WareHouseRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
	}
}
