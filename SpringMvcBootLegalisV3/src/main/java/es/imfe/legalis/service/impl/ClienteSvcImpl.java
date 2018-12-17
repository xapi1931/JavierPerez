package es.imfe.legalis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.imfe.legalis.model.Cliente;
import es.imfe.legalis.model.dao.ClienteDao;
import es.imfe.legalis.service.ClienteSvc;
import es.imfe.legalis.service.SvcException;

@Transactional
@Service
public class ClienteSvcImpl implements ClienteSvc{
	
	@Autowired
	private ClienteDao dao;
	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Cliente cliente) throws SvcException {
		try{
			dao.save(cliente);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
	}
	
	@Override
	public Iterable<Cliente> listar() throws SvcException {
		Iterable<Cliente> res = null;
		
		try{
			res = dao.findAll();
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Cliente cliente) throws SvcException {
		try{
			dao.update(cliente);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Cliente cliente) throws SvcException {
		try{
			cliente = buscarPorIdCliente(cliente.getIdCliente());
			dao.delete(cliente);
		}catch (Exception ex){
			throw new SvcException(ex);
		}		
	}

	@Override
	public Cliente buscarPorIdCliente(int idCliente) throws SvcException {
		Cliente res = null;
		
		try{
			res = dao.findByIdCliente(idCliente);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public Cliente buscarPorUserAndPass(String user, String pass) throws SvcException {
		Cliente res = null;
		
		try{
			res = (Cliente) dao.findByUserAndPass(user, pass);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public List<Cliente> buscarPorProvincia(String provincia) throws SvcException {
		List<Cliente> res = null;
		
		try{
			res = dao.findByProvincia(provincia);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

}
