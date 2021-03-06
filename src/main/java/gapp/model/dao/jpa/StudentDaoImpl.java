package gapp.model.dao.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Students;
import gapp.model.User;
import gapp.model.dao.StudentDao;

@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Students getStudent( Integer id )
    {
        return entityManager.find( Students.class, id );
    }
    
    @Override
    public List<Students> getStudent(User user)
    {
    	try
    	{
    		return entityManager.createQuery("from Students where user=:user",Students.class).setParameter("user", user).getResultList();
    	}
    	catch(NoResultException nre)
    	{
    		return null;
    	}
    }
    @Override
    public List<Students> getAllStudents()
    {
        return entityManager.createQuery( "from Students", Students.class )
            .getResultList();
    }

	@Override
	@Transactional
	public Students saveStudent(Students student) {
		
		return entityManager.merge(student);
	}

}