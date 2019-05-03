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
import vn.com.vuong.request.CategoryRequest;

@SuppressWarnings("serial")
@Entity
@Table(name = "category")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Category implements Serializable{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@JoinColumn(name = "category_parent_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Category categoryParent;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoryParent", fetch = FetchType.LAZY)
	private List<Category> categoryChildrents;
	
	@Column(name = "category_parent_id", updatable = false, insertable = false)
	private Long categoryParentId;
	
	public Category(CategoryRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		if(request.getCategoryParentId() != null) {
			this.setCategoryParent(Category.builder().id(request.getCategoryParentId()).build());
		}
	}
	
	public void setValueFromRequest(CategoryRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		if(request.getCategoryParentId() != null) {
			this.setCategoryParent(Category.builder().id(request.getCategoryParentId()).build());
		}
	}
}
