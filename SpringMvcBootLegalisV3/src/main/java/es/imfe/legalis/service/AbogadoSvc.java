package es.imfe.legalis.service;

import es.imfe.legalis.model.Abogado;

public interface AbogadoSvc {

	/**
	 * Guardar un elemento
	 * @param producto elemento a guardar
	 * @throws SvcException
	 */
	public void guardar(Abogado abogado) throws SvcException;
	
	/**
	 * Actualizar un elemento
	 * @param producto elemento a actualizar
	 * @throws SvcException
	 */
	public void modificar(Abogado abogado) throws SvcException;
	
	/**
	 * Eliminar un elemento
	 * @param producto elemento a eliminar
	 * @throws SvcException
	 */
	public void eliminar(Abogado abogado) throws SvcException;
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Abogado> listar() throws SvcException;
	
	/**
	 * Filtrar por id
	 * @param id clave a buscar
	 * @return producto encontrado, null si no lo encuentra
	 * @throws SvcException
	 */
	public Abogado buscarPorNumColegiado(int numColegiado) throws SvcException;
	
	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 * @throws SvcException
	 */
	public Abogado buscarPorUserAndPass(String user, String pass ) throws SvcException;
	
	/**
	 * 
	 * @param provincia
	 * @return
	 * @throws SvcException
	 */
	public  Iterable<Abogado> buscarPorProvincia(String provincia) throws SvcException;
}
