package vn.com.vuong.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vuong.request.MenuRequest;

@SuppressWarnings("serial")
@Entity
@Table(name = "menu")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Menu implements Serializable {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "icon")
	private String icon;
	
	@JoinColumn(name = "menu_parent_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Menu parent;
	
	@JsonIgnore
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<Menu> childrents;
	
	@Column(name = "menu_parent_id", updatable = false, insertable = false)
	private Long parentId;
	
	public Menu(MenuRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		if(request.getParentId() != null) {
			this.setParent(Menu.builder().id(request.getParentId()).build());
		}
	}
	
	public void setValueFromRequest(MenuRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		if(request.getParentId() != null) {
			this.setParent(Menu.builder().id(request.getParentId()).build());
		}
	}
}
