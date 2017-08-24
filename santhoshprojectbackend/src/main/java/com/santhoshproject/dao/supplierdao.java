package com.santhoshproject.dao;
import java.util.List;
import org.springframework.stereotype.Service;
import com.santhoshproject.model.supplier;
@Service
public interface supplierdao 
{
boolean insertuser (supplier i);
boolean updateuser (supplier u);
boolean deleteuser (int id);
List<supplier> showall();
supplier showone(int id);
}
