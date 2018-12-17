package es.imfe.legalis.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.imfe.legalis.model.Abogado;
import es.imfe.legalis.model.dao.AbogadoDao;
import es.imfe.legalis.model.dao.DaoException;

@Repository
public class AbogadoDaoImpl implements AbogadoDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Abogado abogado) throws DaoException{
		try{
			sessionFactory.getCurrentSession().save(abogado);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
	}
		
	@Override
	public void update(Abogado abogado) throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(abogado);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void delete(Abogado abogado) throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(abogado);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Abogado> findAll() throws DaoException {
		List<Abogado> res = null;
		
		try{					
			String hql = "FROM Abogado";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	
	@Override
	public Abogado findByNumColegiado(int numColegiado) throws DaoException {
		Abogado res = null;
		
		try{					
			res = (Abogado) sessionFactory.getCurrentSession().get(Abogado.class, numColegiado);
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abogado> findByProvincia(String provincia) throws DaoException{
		List<Abogado> res = null;
		
		try{					
			String hql = "FROM Abogado a WHERE a.provincia LIKE :provincia";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("provincia", "%" + provincia + "%")
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}


	@Override
	public Abogado findByUserAndPass(String user, String pass) throws DaoException {
		Abogado res = null;
		
		try{					
			String hql = "FROM Abogado a WHERE a.user = :user AND a.pass = :pass";
			res = (Abogado) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("user", user)
					.setParameter("pass", pass)
					.uniqueResult();
					
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}
