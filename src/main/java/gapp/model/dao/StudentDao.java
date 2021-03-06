package gapp.model.dao;

import java.util.List;

import gapp.model.Students;
import gapp.model.User;


public interface StudentDao{
	
	Students getStudent( Integer id );

    List<Students> getAllStudents();
    
    List<Students> getStudent(User user);

	Students saveStudent(Students student);
    
}