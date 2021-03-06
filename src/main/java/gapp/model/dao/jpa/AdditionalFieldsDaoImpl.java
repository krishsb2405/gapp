package gapp.model.dao.jpa;



import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AdditionalFields;
import gapp.model.Department;
import gapp.model.dao.AdditionalFieldsDao;

@Repository
public class AdditionalFieldsDaoImpl implements AdditionalFieldsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AdditionalFields getAdditionalField( Integer id )
    {
        return entityManager.find( AdditionalFields.class, id );
    }
    
    
    @Override
    public List<AdditionalFields> getAllAdditionalFields()
    {
        return entityManager.createQuery( "from AdditionalFields", AdditionalFields.class )
            .getResultList();
    }


	@Override
	@Transactional
	public AdditionalFields saveAdditionalFieldsDao(AdditionalFields additionalFields) {
		return entityManager.merge(additionalFields);
	}


	@Override
	@Transactional
	public void deleteField(AdditionalFields additionalField) {
		// TODO Auto-generated method stub
		entityManager.remove(additionalField);
	}


	@Override
	public List<AdditionalFields> getAdditionalFieldsOfDepartment(Collection<Department> dept) {
		// TODO Auto-generated method stub
		//String query = "select af from AdditonalFields af left join fetch ";
		return entityManager.createQuery("from AdditionalFields where departments=:dept", AdditionalFields.class).setParameter("departments", dept).getResultList();
	}

}