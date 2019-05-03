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
import vn.com.vuong.request.ItemRequest;

@SuppressWarnings("serial")
@Entity
@Table(name = "item")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Item implements Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;
	
	@JoinColumn(name = "item_sub_type_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ItemSubType itemSubType;
	
	@Column(name = "item_sub_type_name")
	private String itemSubTypeName;
	
	@Column(name = "item_sub_type_id", updatable = false, insertable = false)
	private Long itemSubTypeId;
	
	public Item(ItemRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		this.setItemSubType(request.getItemSubType());
		this.setItemSubTypeName(request.getItemSubType().getName());
	}

	public void setValueFromRequest(ItemRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		this.setItemSubType(request.getItemSubType());
		this.setItemSubTypeName(request.getItemSubType().getName());
	}
}
