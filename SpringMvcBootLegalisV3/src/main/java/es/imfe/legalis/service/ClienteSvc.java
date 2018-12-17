package es.imfe.legalis.service;

import es.imfe.legalis.model.Cliente;

public interface ClienteSvc {

	/**
	 * Guardar un elemento
	 * @param producto elemento a guardar
	 * @throws SvcException
	 */
	public void guardar(Cliente cliente) throws SvcException;
	
	/**
	 * Actualizar un elemento
	 * @param producto elemento a actualizar
	 * @throws SvcException
	 */
	public void modificar(Cliente cliente) throws SvcException;
	
	/**
	 * Eliminar un elemento
	 * @param producto elemento a eliminar
	 * @throws SvcException
	 */
	public void eliminar(Cliente cliente) throws SvcException;
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Cliente> listar() throws SvcException;
	
	/**
	 * Filtrar por id
	 * @param id clave a buscar
	 * @return producto encontrado, null si no lo encuentra
	 * @throws SvcException
	 */
	public Cliente buscarPorIdCliente(int idCliente) throws SvcException;
	
	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 * @throws SvcException
	 */
	public Cliente buscarPorUserAndPass(String user, String pass ) throws SvcException;
	
	/**
	 * 
	 * @param provincia
	 * @return
	 * @throws SvcException
	 */
	public Iterable<Cliente> buscarPorProvincia(String provincia) throws SvcException;
}
