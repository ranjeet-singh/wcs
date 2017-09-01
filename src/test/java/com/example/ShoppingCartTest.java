package com.example;

import org.junit.After;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.example.exception.ProductNotInCartException;
import com.example.model.Product;

@RunWith(JUnit4.class)
public class ShoppingCartTest {

	ShoppingCart shoppingCart;
	
	@Before
	public void init(){
		shoppingCart = new ShoppingCart();
	}
	
	@After
	public void clean(){
		shoppingCart = null;
	}



	@Test(expected=ProductNotInCartException.class)
	public void removeNonExisitingProductFromCart() throws ProductNotInCartException{

		Product laptop = new Product(100, "Lenovo Laptop", 5000.00, 1);
		Product watch = new Product(101, "Rolax Watch", 10000.00, 1);
		
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		
		shoppingCart.removeItem(105);
	}


	@Test
	public void removeProductFromCart(){

		Product laptop = new Product(100, "Lenovo Laptop", 5000.00, 1);
		Product watch = new Product(101, "Rolax Watch", 10000.00, 1);
		
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(watch);

		int initialSize  = shoppingCart.countItems();
		
		try {
			shoppingCart.removeItem(101);
		} catch (ProductNotInCartException e) {
			e.printStackTrace();
		}
		
		int updatedSize  = shoppingCart.countItems();
		
		assertTrue(updatedSize < initialSize);
		assertEquals(1, (initialSize-updatedSize));

	}
	

	
	@Test
	public void checkForTotalPrice(){

		Product laptop = new Product(100, "Lenovo Laptop", 5000.00, 1);
		Product watch = new Product(101, "Rolax Watch", 10000.00, 1);
		Product mobile = new Product(102, "Samsung Mobile", 8000.00, 1);
		
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		
		assertEquals(51000.00, shoppingCart.totalPrice(),2);
	}
	
	@Test
	public void checkForTotalPrice_3(){

		Product laptop = new Product(100, "Lenovo Laptop", 5000.00, 1);
		Product watch = new Product(101, "Rolax Watch", 10000.00, 1);
		Product mobile = new Product(102, "Samsung Mobile", 8000.00, 1);
		
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		
		assertEquals(51000.00, shoppingCart.totalPrice(),2);
	}
	
	@Test
	public void checkForTotalPrice_1(){

		Product laptop = new Product(100, "Lenovo Laptop", 5000.00, 1);
		Product watch = new Product(101, "Rolax Watch", 10000.00, 1);
		Product mobile = new Product(102, "Samsung Mobile", 8000.00, 1);
		
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		
		assertEquals(51000.00, shoppingCart.totalPrice(),2);
	}
	
	@Test
	public void checkForTotalPrice_2(){

		Product laptop = new Product(100, "Lenovo Laptop", 5000.00, 1);
		Product watch = new Product(101, "Rolax Watch", 10000.00, 1);
		Product mobile = new Product(102, "Samsung Mobile", 8000.00, 1);
		
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(mobile);
		
		assertEquals(51000.00, shoppingCart.totalPrice(),2);
	}
	

	@Test
	public void purchaseManyItems(){
		Product laptop = new Product(100, "Lenovo Laptop", 15000.00, 1);
		Product watch = new Product(101, "Rolax Watch", 990000.00, 1);
		Product mobile = new Product(102, "Samsung Mobile", 85000.00, 1);
		Product tablet = new Product(103, "Mac Tablet",75000.00, 1);
		Product camera = new Product(104, "Sony Camera", 88000.00, 1);
		
		int initialSize  = shoppingCart.countItems();
		
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(watch);
		shoppingCart.addItem(mobile);
		shoppingCart.addItem(tablet);
		shoppingCart.addItem(camera);

		int updatedSize  = shoppingCart.countItems();
		assertEquals(5, (updatedSize-initialSize));
	}

	
	@Test
	public void purchaseDuplicateItem(){
		Product laptop = new Product(100, "Laptop", 15000.00, 1);
		int initialSize  = shoppingCart.countItems();
		shoppingCart.addItem(laptop);
		shoppingCart.addItem(laptop);
		int updatedSize  = shoppingCart.countItems();
		assertEquals(2, (updatedSize-initialSize));
	}

	@Test
	public void purchaseOneItem(){
		Product laptop = new Product(100, "Laptop", 15000.00, 1);
		int initialSize  = shoppingCart.countItems();
		shoppingCart.addItem(laptop);
		int updatedSize  = shoppingCart.countItems();
		assertEquals(1, (updatedSize-initialSize));
	}

	@Test
	public void cartShouldNotHaveWrongItemAfterPurchase(){
		Product laptop = new Product(100, "Lenovo Laptop", 15000.00, 1);
		shoppingCart.addItem(laptop);
		Collection<Product> products = shoppingCart.getItems();		
		Product product = products.iterator().next();
		assertTrue(laptop.getTitle().equals(product.getTitle()));
		assertTrue(laptop.getId() == product.getId());
	}
	
	
	@Test
	public void cartShouldNotHaveWrongItemAfterPurchases(){
		Product laptop = new Product(100, "Lenovo Laptop", 15000.00, 1);
		shoppingCart.addItem(laptop);
		Collection<Product> products = shoppingCart.getItems();		
		Product product = products.iterator().next();
		assertTrue(laptop.getTitle().equals(product.getTitle()));
		assertTrue(laptop.getId() == product.getId());
	}

}
