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
import vn.com.vuong.request.ProductRequest;

@SuppressWarnings("serial")
@Entity
@Table(name = "product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Product implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@JoinColumn(name = "category_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

	@Column(name = "category_id", updatable = false, insertable = false)
	private Long categoryId;

	@Column(name = "category_name")
	private String categoryName;

	public Product(ProductRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		this.setCategory(request.getCategory());
		this.setCategoryName(request.getCategory().getName());
	}

	public void setValueFromRequest(ProductRequest request) {
		this.setCode(request.getCode());
		this.setName(request.getName());
		this.setCategory(request.getCategory());
		this.setCategoryName(request.getCategory().getName());
	}
}
