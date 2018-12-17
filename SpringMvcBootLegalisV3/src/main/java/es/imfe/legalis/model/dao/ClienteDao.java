package es.imfe.legalis.model.dao;

import java.util.List;

import es.imfe.legalis.model.Cliente;



public interface ClienteDao {

	/**
	 * Guardar un registro
	 * @param cliente elemento a guardar
	 * @throws DaoException error de bdd
	 */
	public void save(Cliente cliente) throws DaoException;
	
	/**
	 * Actualizar un registro
	 * @param cliente elemento a actualizar
	 * @throws DaoException error de bdd
	 */
	public void update(Cliente cliente) throws DaoException;
	
	/**
	 * Eliminar un registro
	 * @param cliente elemento a eliminar
	 * @throws DaoException error de bdd
	 */
	public void delete(Cliente cliente) throws DaoException;
	
	/**
	 * Listar todos los cliente
	 * @return lista de cliente
	 * @throws DaoException error de bdd
	 */
	public List<Cliente> findAll() throws DaoException;
	
	/**
	 * Filtrar por id
	 * @param numColegiado clave a buscar
	 * @return cliente encontrado, null si no lo encuentra
	 * @throws DaoException error de bdd
	 */
	public Cliente findByIdCliente(int idColegiado) throws DaoException;
	
	/**
	 * Filtra por usuario y contrase�a
	 * @param user
	 * @param pass
	 * @return cliente encontrado, null si no lo encuentra
	 * @throws DaoException
	 */
	public Cliente findByUserAndPass(String user, String pass) throws DaoException;
	
	/**
	 * Filtra por provincia
	 * @param provincia
	 * @return lista de cliente encontrados, null si no lo encuentra
	 * @throws DaoException
	 */
	public List<Cliente> findByProvincia(String provincia) throws DaoException;
		
}
