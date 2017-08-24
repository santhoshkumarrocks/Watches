package com.santhoshproject.santhoshprojectdaoimpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.santhoshproject.dao.Registerdao;
import com.santhoshproject.model.Register;
import com.santhoshproject.model.product;

@Repository
public class Registerdaoimpl implements Registerdao 
{
@Autowired
SessionFactory sessionfactory;

	public boolean insertuser(Register i) 
	{
	try
	{
		Session s=sessionfactory.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		s.save(i);
		t.commit();
		s.close();
		return(true);
		
	}
	catch(Exception e)
	{
		return false;
	}

}

	public List<Register> showall() {
		try
		{
		Session s=sessionfactory.openSession();
		Transaction t=s.getTransaction();
		t.begin();
		List<Register> l=s.createQuery("from Register").list();
		t.commit();
		s.close();
		return l;
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
