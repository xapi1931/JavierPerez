package es.imfe.legalis.model.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.imfe.legalis.model.Caso;
import es.imfe.legalis.model.dao.CasoDao;
import es.imfe.legalis.model.dao.DaoException;

@Repository
public class CasoDaoImpl implements CasoDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Caso caso) throws DaoException {
		try{
			sessionFactory.getCurrentSession().save(caso);	
		}catch (Exception ex){
			throw new DaoException(ex);
		}
	
	}

	@Override
	public void update(Caso caso) throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(caso);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void delete(Caso caso) throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(caso);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caso> findAll() throws DaoException {
		List<Caso> res = null;	
		try{					
			String hql = "FROM Caso";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	
	@Override
	public Caso findByNumCaso(int numCaso) throws DaoException {
		Caso res = null;
		
		try{					
			res = (Caso) sessionFactory.getCurrentSession().get(Caso.class, numCaso);
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caso> findByTipoCaso(String tipoCaso) throws DaoException {
		List<Caso> res = null;	
		try{					
			String hql = "FROM Caso c WHERE c.tipoCaso LIKE :tipoCaso";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("tipoCaso", "%" + tipoCaso + "%")
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caso> findByNumcolegiado(int numColegiado) throws DaoException {
		List<Caso> res = null;	
		try{					
			String hql = "FROM Caso c WHERE c.numColegiado = :numColegiado";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("colegiado", numColegiado)
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caso> findByIdCliente(int idCliente) throws DaoException {
		List<Caso> res = null;	
		try{					
			String hql = "FROM Caso c WHERE c.idCliente =" + idCliente;
			res = sessionFactory.getCurrentSession().createQuery(hql)					
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caso> findByFechaCaso(Date fechaCaso) throws DaoException {
		List<Caso> res = null;	
		try{					
			String hql = "FROM Caso c WHERE c.fechaCaso = :fechaCaso";
			res = sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("fechaCaso",fechaCaso)
					.list();
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
		return res;
	}

}