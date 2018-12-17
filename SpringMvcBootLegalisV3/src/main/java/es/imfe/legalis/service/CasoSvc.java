package es.imfe.legalis.service;

import java.util.Date;

import es.imfe.legalis.model.Caso;

public interface CasoSvc {

	/**
	 * Guardar un elemento
	 * @param caso elemento a guardar
	 * @throws SvcException
	 */
	public void guardar(Caso caso) throws SvcException;
	
	/**
	 * Actualizar un elemento
	 * @param caso elemento a actualizar
	 * @throws SvcException
	 */
	public void modificar(Caso caso) throws SvcException;
	
	/**
	 * Eliminar un elemento
	 * @param caso elemento a eliminar
	 * @throws SvcException
	 */
	public void eliminar(Caso caso) throws SvcException;
	
	/**
	 * Listar todos los casos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Caso> listar() throws SvcException;
	
	/**
	 * Filtrar por id
	 * @param id clave a buscar
	 * @return caso encontrado, null si no lo encuentra
	 * @throws SvcException
	 */
	public Caso buscarPorNumCaso(int numCaso) throws SvcException;
	
	/**
	 * 
	 * @param tipoCaso
	 * @return
	 * @throws SvcException
	 */
	public Iterable<Caso> buscarPorTipoCaso(String tipoCaso) throws SvcException;
	
	/**
	 * 
	 * @param abogado
	 * @return
	 * @throws SvcException
	 */
	public Iterable<Caso> buscarPorNumColegiado(int numColegiado) throws SvcException;
	
	/**
	 * 
	 * @param Cliente
	 * @return
	 * @throws SvcException
	 */
	public Iterable<Caso> buscarPorIdCliente(int  idCliente) throws SvcException;
	
	/**
	 * 
	 * @param fechaCaso
	 * @return
	 * @throws SvcException
	 */
	public Iterable<Caso> buscarPorFecha(Date  fechaCaso) throws SvcException;
}
