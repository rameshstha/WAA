package com.ramesh;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
	List<Product> productList = new ArrayList<Product>();

	public ProductData() {
		productList.add(new Product("A32581", "The winner takes it all", 12.95, 1,0));
		productList.add(new Product("A33278", "Yellow Submarine", 11.35, 1,0));
		productList.add(new Product("A21584", "Captain Returns", 12.58, 1,0));
		productList.add(new Product("A12458", "Soldiers", 10.54, 1,0));
		productList.add(new Product("A56417", "Tom and Jerry", 13.15, 1,0));
	}

	public List<Product> getProductList() {
		return productList;
	}
}
