package es.imfe.legalis.model.dao;

import java.util.Date;
import java.util.List;

import es.imfe.legalis.model.Caso;


public interface CasoDao {

	/**
	 * Guardar un registro
	 * @param caso elemento a guardar
	 * @throws DaoException error de bdd
	 */
	public void save(Caso caso) throws DaoException;
	
	/**
	 * Actualizar un registro
	 * @param caso elemento a actualizar
	 * @throws DaoException error de bdd
	 */
	public void update(Caso caso) throws DaoException;
	
	/**
	 * Eliminar un registro
	 * @param caso elemento a eliminar
	 * @throws DaoException error de bdd
	 */
	public void delete(Caso caso) throws DaoException;
	
	/**
	 * Lista todos los casos
	 * @return lista de casos
	 * @throws DaoException error de bdd
	 */
	public List<Caso> findAll() throws DaoException;
	
	/**
	 * Filtrar por numCaso
	 * @param numCaso clave a buscar
	 * @return caso encontrado, null si no lo encuentra
	 * @throws DaoException error de bdd
	 */
	public Caso findByNumCaso(int numCaso) throws DaoException;
	
	/**
	 * Filtrar por tipo de caso
	 * @param tipoCaso
	 * @return lista de casos encontrados, null si no encuentra
	 * @throws DaoException
	 */
	public List<Caso> findByTipoCaso(String tipoCaso) throws DaoException;
	
	/**
	 * Filtrar por numero de colegiado
	 * @param numColegiado
	 * @return lista de casos encontrados, null si no encuentra
	 * @throws DaoException
	 */
	public List<Caso> findByNumcolegiado(int numColegiado) throws DaoException;
	
	/**
	 *  Filtrar por numero de cliente
	 * @param numCliente
	 * @return lista de casos encontrados, null si no encuentra
	 * @throws DaoException
	 */
	public List<Caso> findByIdCliente(int numCliente) throws DaoException;
	
	/**
	 * Filtrar por fecha de caso
	 * @param fechaCaso
	 * @return lista de casos encontrados, null si no encuentra
	 * @throws DaoException
	 */
	public List<Caso> findByFechaCaso(Date fechaCaso) throws DaoException;
}
