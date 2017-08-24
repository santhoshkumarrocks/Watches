package com.santhoshproject.santhoshprojectdaoimpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.santhoshproject.dao.supplierdao;
import com.santhoshproject.model.supplier;
@Repository
public class supplierdaoimpl implements supplierdao 
{
@Autowired
SessionFactory sessionfactory;

	public boolean insertuser(supplier i) 
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
	
	public boolean updateuser(supplier u) 
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
		supplier c=s.get(supplier.class,id);
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
	
	public List<supplier> showall() 
	{
		try
		{
		Session s=sessionfactory.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		List<supplier> a=s.createQuery("from supplier").list();
		t.commit();
		s.close();
		return a;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}
	
	public supplier showone(int id) 
	{
		try
		{
		Session s=sessionfactory.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		supplier x =s.get(supplier.class,id);
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
	

	
	