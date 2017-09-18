package com.santhoshproject.santhoshprojectdaoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.santhoshproject.dao.CartDAO;
import com.santhoshproject.model.cart;
import com.santhoshproject.model.cartid;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertproductIntoCart(cart cart) 
	{
		try {
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(cart);
			t.commit();
			s.close();
			return true;
		} 	
			catch (Exception e) 
		{
			return false;
		}
	}

	public List<cart> singleUserCart(String username) {
		// TODO Auto-generated method stub
		try 
		{
			Session s =sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Criteria c=s.createCriteria(cart.class);
			c.add(Restrictions.eq("cartid", username));
			List<cart> singleusercart=c.list();
			t.commit();
			s.close();
			return singleusercart;
		} 
		catch (Exception e)
		{
			return null;
		}
	}

	public boolean updateproducttocart(cart cart) {
		// TODO Auto-generated method stub
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.update(cart);
			t.commit();
			s.close();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

	public List<cart> singleprodfromcart(String prodname, String username) {
		// TODO Auto-generated method stub
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Criteria c=s.createCriteria(cart.class);
			c.add(Restrictions.eq("productname", prodname));
			c.add(Restrictions.eq("cartid", username));
			List<cart> singleprodfromusercart=c.list();
			t.commit();
			s.close();
			return singleprodfromusercart;
		} 
		catch (Exception e)
		{
			return null;
		}
	}

	public boolean initcartforuser(cartid cartid) {
		// TODO Auto-generated method stub
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(cartid);
			t.commit();
			s.close();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean deletecartproduct(int id) {
		// TODO Auto-generated method stub
		try 
		{
			Session s = sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			cart cartprodel=s.get(cart.class,id);
			s.delete(cartprodel);
			t.commit();
			s.close();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}

	public int totalproductsincartforuser(String username) {
		// TODO Auto-generated method stub
		try 
		{
			Session s =sessionFactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Criteria c=s.createCriteria(cart.class);
			c.add(Restrictions.eq("cartid", username));
			List<cart> singleusercart=c.list();
			t.commit();
			s.close();
			return singleusercart.size();
		} 
		catch (Exception e)
		{
			return 0;
		}
	}

}
