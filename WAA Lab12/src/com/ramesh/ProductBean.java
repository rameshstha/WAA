package com.ramesh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProductBean {
	private ProductData pd;
	List<Product> productdetails = new ArrayList<Product>();
	List<Product> shoppingList = new ArrayList<Product>();
	private double totalPrice = 0.0;

	public ProductBean() {
		pd = new ProductData();
		productdetails = pd.getProductList();
	}

	public List<Product> getProductdetails() {
		return productdetails;
	}

	public List<Product> getShoppingList() {
		return shoppingList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public String shoppingCartList(String productCode, String productName, double price, int quantity) {
		Iterator<Product> it = shoppingList.iterator();
		totalPrice += price * quantity;
		while (it.hasNext()) {
			Product p = (Product) it.next();

			if (p.getProductCode().equals(productCode)) {
				quantity = p.getQuantity() + 1;
				it.remove();
			}
		}

		shoppingList.add(new Product(productCode, productName, price, quantity, price * quantity));
		return "shoppingCart";
	}

	public String removeFromCart(String productCode, double price) {
		Iterator<Product> it = shoppingList.iterator();
		while (it.hasNext()) {
			Product p = (Product) it.next();

			if (p.getProductCode().equals(productCode)) {
				totalPrice -= price;
				it.remove();
			}
		}
		return "shoppingCart";
	}

	public String continueShopping() {
		return "index";
	}

	public String showShoppingCart() {
		return "shoppingCart";
	}
}
