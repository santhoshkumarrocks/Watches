package com.santhoshproject.dao;
import java.util.List;
import org.springframework.stereotype.Service;
import com.santhoshproject.model.category;
import com.santhoshproject.model.product;
import com.santhoshproject.model.supplier;
@Service
public interface categorydao 
{
boolean insertuser (category p);
boolean updateuser (category u);
boolean deleteuser (int id);
List<category> showall();
category showone(int id);
}
