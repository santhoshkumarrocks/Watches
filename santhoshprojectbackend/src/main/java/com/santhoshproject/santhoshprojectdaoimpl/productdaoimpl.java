package com.santhoshproject.santhoshprojectdaoimpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.santhoshproject.dao.productdao;
import com.santhoshproject.model.product;
@Repository
public class productdaoimpl implements productdao 
{
@Autowired
SessionFactory sessionfactory;

	public boolean insertuser(product i) 
	{
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			s.save(i);
			t.commit();
			s.close();
			return true;
			}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateuser(product u) 
	{
		try
		{
			Session s=sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			s.update(u);
			t.commit();
			s.close();
			return true;
			}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteuser(int id) 
	{
		try
		{
		Session s=sessionfactory.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		product c=s.get(product.class,id);
		s.delete(c);
		t.commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public List<product> showall() 
	{
		try
		{
		Session s=sessionfactory.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		List<product> l=s.createQuery("from product").list();
		t.commit();
		s.close();
		return l;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public product showone(int id) 
	{
		try
		{
		Session s=sessionfactory.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		product x =s.get(product.class,id);
		t.commit();
		s.close();
		return x;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
}	
		