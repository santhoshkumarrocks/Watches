package com.santhoshproject.santhoshprojectdaoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.santhoshproject.dao.categorydao;
import com.santhoshproject.model.category;

@Repository
public class categorydaoimpl implements categorydao {
	@Autowired
	SessionFactory sessionfactory;

	
	public boolean insertuser(category i) {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(i);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public boolean updateuser(category u) {
		{
			try {
				Session s = sessionfactory.openSession();
				Transaction t = s.getTransaction();
				t.begin();
				s.update(u);
				t.commit();
				s.close();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	
	public boolean deleteuser(int id) {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			category c = s.get(category.class, id);
			s.delete(c);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public List<category> showall() {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			List<category> l = s.createQuery("from category").list();
			t.commit();
			s.close();
			return l;
		} catch (Exception e) {
			return null;
		}
	}


	public category showone(int id) {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			category x = s.get(category.class, id);
			t.commit();
			s.close();
			return x;
		} catch (Exception e) {
			return null;
		}

	}

}
