package es.imfe.legalis.model.dao;

import java.util.List;

import es.imfe.legalis.model.Abogado;

public interface AbogadoDao {

	/**
	 * Guardar un registro
	 * @param abogado elemento a guardar
	 * @throws DaoException error de bdd
	 */
	public void save(Abogado abogado) throws DaoException;
	
	/**
	 * Actualizar un registro
	 * @param abogado elemento a actualizar
	 * @throws DaoException error de bdd
	 */
	public void update(Abogado abogado) throws DaoException;
	
	/**
	 * Eliminar un registro
	 * @param abogado elemento a eliminar
	 * @throws DaoException error de bdd
	 */
	public void delete(Abogado abogado) throws DaoException;
	
	/**
	 * Listar todos los abogados
	 * @return lista de abogados
	 * @throws DaoException error de bdd
	 */
	public List<Abogado> findAll() throws DaoException;
	
	/**
	 * Filtrar por id
	 * @param numColegiado clave a buscar
	 * @return abogado encontrado, null si no lo encuentra
	 * @throws DaoException error de bdd
	 */
	public Abogado findByNumColegiado(int numColegiado) throws DaoException;
	
	/**
	 * Filtra por usuario y contraseña
	 * @param user
	 * @param pass
	 * @return abogado encontrado, null si no lo encuentra
	 * @throws DaoException
	 */
	public Abogado findByUserAndPass(String user, String pass) throws DaoException;
	
	/**
	 * Filtra por provincia
	 * @param provincia
	 * @return lista de abogados encontrados, null si no lo encuentra
	 * @throws DaoException
	 */
	public List<Abogado> findByProvincia(String provincia) throws DaoException;
	
}
