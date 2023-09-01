package com.product.project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="_order")
public class Order {
	@Id
	@GeneratedValue
	private int id;
	private Long orderNumber;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name="order_id",referencedColumnName = "id")
	@JoinTable(name = "order_product", joinColumns = @JoinColumn(name ="order_id"),inverseJoinColumns=@JoinColumn(name="product_id"))
	private List<Product> product;
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public Order() {
		super();
	}
	public Order(int id, Long orderNumber) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
