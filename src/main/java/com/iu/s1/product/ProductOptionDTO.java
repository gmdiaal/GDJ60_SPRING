package com.iu.s1.product;

public class ProductOptionDTO {
	
	private Long option_num;
	private Long product_num;
	private String name;
	private Long price;
	private Long stock;
	
	public Long getOption_num() {
		return option_num;
	}
	public void setOption_num(Long option_num) {
		this.option_num = option_num;
	}
	public Long getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Long product_num) {
		this.product_num = product_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	
	
}
