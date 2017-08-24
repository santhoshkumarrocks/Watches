package com.santhoshproject.dao;
import java.util.List;

import org.springframework.stereotype.Service;
import com.santhoshproject.model.Register;
@Service
public interface Registerdao 
{
boolean insertuser (Register i);
List<Register> showall();
}
