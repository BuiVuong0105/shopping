package vn.com.vuong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.request.ItemSubTypeRequest;

@SuppressWarnings("serial")
@Entity
@Table(name = "item_sub_type")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ItemSubType implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "item_type_name")
	private String itemTypeName;

	@JoinColumn(name = "item_type_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ItemType itemType;

	@Column(name = "item_type_id", updatable = false, insertable = false)
	private Long itemTypeId;

	public ItemSubType(ItemSubTypeRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		this.setItemTypeName(request.getItemType().getName());
		this.setItemType(request.getItemType());
	}

	public void setValueFromRequest(ItemSubTypeRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		this.setItemTypeName(request.getItemType().getName());
		this.setItemType(request.getItemType());
	}
}
