package com.santhoshproject.dao;
import java.util.List;
import org.springframework.stereotype.Service;
import com.santhoshproject.model.product;
@Service
public interface productdao 
{
boolean insertuser (product i);
boolean updateuser (product u);
boolean deleteuser (int id);
List<product> showall();
product showone(int id);
}
