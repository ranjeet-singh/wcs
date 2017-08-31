package com.example;

import com.example.exception.ProductNotInCartException;
import com.example.model.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	private Map<Integer, Product> cart = new HashMap<>();

	public void addItem(Product product) {
		int productId = product.getId();
		if(cart.containsKey(productId)){
			Product existingProduct = cart.get(productId);
			existingProduct.setQty(existingProduct.getQty()+1);
		}else{
			cart.put(productId, product);
		}
	}

	public int countItems() {
		int count = 0;
		Collection<Product> collection = cart.values();
		for(Product product : collection){
			count = count + product.getQty();	
		}
		return count;
	}
	
	public Collection<Product> getItems() {
		return cart.values();
	}

	public double totalPrice() {
		double total = 0.0;
		Collection<Product> collection = cart.values();
		for(Product product : collection){
			double itemPrice = product.getPrice() * product.getQty();	
			total = total + itemPrice;
		}
		return total;
	}
	
	public void removeItem(int productId) throws ProductNotInCartException{
		if(cart.containsKey(productId)){
			Product existingProduct = cart.get(productId);
			existingProduct.setQty(existingProduct.getQty()-1);
		}else{
			throw new ProductNotInCartException("Product with ID : "+
					productId+" is not there in cart!!!!!");
		}
	}


	
}
