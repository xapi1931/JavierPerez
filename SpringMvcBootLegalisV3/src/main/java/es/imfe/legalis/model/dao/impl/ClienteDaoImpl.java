package es.imfe.legalis.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.imfe.legalis.model.Cliente;
import es.imfe.legalis.model.dao.ClienteDao;
import es.imfe.legalis.model.dao.DaoException;

@Repository
public class ClienteDaoImpl implements ClienteDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Cliente cliente) throws DaoException{
		try{
			sessionFactory.getCurrentSession().save(cliente);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
	}
		
	@Override
	public void update(Cliente cliente) throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(cliente);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void delete(Cliente cliente) throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(cliente);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() throws DaoException {
		List<Cliente> res = null;
		
		try{					
			String hql = "FROM Cliente";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	
	@Override
	public Cliente findByIdCliente(int idCliente) throws DaoException {
		Cliente res = null;
		
		try{					
			res = (Cliente) sessionFactory.getCurrentSession().get(Cliente.class, idCliente);
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findByProvincia(String provincia) throws DaoException{
		List<Cliente> res = null;
		
		try{					
			String hql = "FROM Cliente c WHERE c.provincia LIKE :provincia";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("provincia", "%" + provincia + "%")
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}


	@Override
	public Cliente findByUserAndPass(String user, String pass) throws DaoException {
		Cliente res = null;
		
		try{					
			String hql = "FROM Cliente c WHERE c.user = :user AND c.pass = :pass";
			res = (Cliente) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("user", user)
					.setParameter("pass", pass)
					.uniqueResult();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}
