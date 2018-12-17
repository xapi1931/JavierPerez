package es.imfe.legalis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.imfe.legalis.model.Abogado;
import es.imfe.legalis.model.dao.AbogadoDao;
import es.imfe.legalis.service.AbogadoSvc;
import es.imfe.legalis.service.SvcException;

@Transactional
@Service
public class AbogadoSvcImpl implements AbogadoSvc{
	
	@Autowired
	private AbogadoDao dao;
	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Abogado producto) throws SvcException {
		try{
			dao.save(producto);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
	}
	
	@Override
	public Iterable<Abogado> listar() throws SvcException {
		Iterable<Abogado> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Abogado abogado) throws SvcException {
		try{
			dao.update(abogado);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Abogado abogado) throws SvcException {
		try{
			dao.delete(abogado);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	@Override
	public Abogado buscarPorNumColegiado(int numColegiado) throws SvcException {
		Abogado res = null;
		
		try{
			res = dao.findByNumColegiado(numColegiado);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public Abogado buscarPorUserAndPass(String user, String pass) throws SvcException {
		Abogado res = null;
		
		try{
			res = dao.findByUserAndPass(user, pass);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public List<Abogado> buscarPorProvincia(String provincia) throws SvcException {
		List<Abogado> res = null;
		
		try{
			res = dao.findByProvincia(provincia);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

}
