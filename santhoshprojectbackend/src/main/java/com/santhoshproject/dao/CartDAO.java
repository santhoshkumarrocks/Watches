package com.santhoshproject.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.santhoshproject.model.cart;
import com.santhoshproject.model.cartid;

@Service
public interface CartDAO {
	boolean insertproductIntoCart(cart cart);
List<cart> singleUserCart(String username);
	
	boolean updateproducttocart(cart cart);
	
	List<cart> singleprodfromcart(String prodname,String username);
	
	boolean initcartforuser(cartid cartid);
	boolean deletecartproduct(int id);
	
	int totalproductsincartforuser(String username);

}
