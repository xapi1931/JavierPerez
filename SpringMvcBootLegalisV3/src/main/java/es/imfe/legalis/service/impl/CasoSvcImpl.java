package es.imfe.legalis.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.imfe.legalis.model.Caso;
import es.imfe.legalis.model.dao.CasoDao;
import es.imfe.legalis.service.CasoSvc;
import es.imfe.legalis.service.SvcException;

@Transactional
@Service
public class CasoSvcImpl implements CasoSvc{
	
	@Autowired
	private CasoDao dao;
	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Caso producto) throws SvcException {
		try{
			dao.save(producto);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
	}
	
	@Override
	public Iterable<Caso> listar() throws SvcException {
		Iterable<Caso> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Caso producto) throws SvcException {
		try{
			dao.update(producto);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Caso caso) throws SvcException {
		try{
			caso = buscarPorNumCaso(caso.getNumCaso());
			dao.delete(caso);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	@Override
	public Caso buscarPorNumCaso(int numCaso) throws SvcException {
		Caso res = null;
		
		try{
			res = dao.findByNumCaso(numCaso);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public Iterable<Caso> buscarPorTipoCaso(String tipoCaso) throws SvcException {
		List<Caso> res = null;
		
		try{
			res = dao.findByTipoCaso(tipoCaso);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public Iterable<Caso> buscarPorNumColegiado(int numColegiado) throws SvcException {
		List<Caso> res = null;
		
		try{
			res = dao.findByNumcolegiado(numColegiado);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public Iterable<Caso> buscarPorIdCliente(int idCliente) throws SvcException {
		List<Caso> res = null;
		
		try{
			res = dao.findByIdCliente(idCliente);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public Iterable<Caso> buscarPorFecha(Date fechaCaso) throws SvcException {
		List<Caso> res = null;
		
		try{
			res = dao.findByFechaCaso(fechaCaso);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;	
	}

}
