package edu.hm.cs.fwp.cloudtrain.adapter.persistence.jpa.repository;

import edu.hm.cs.fwp.cloud.common.persistence.jpa.repository.AbstractGenericRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Konkrete Implementierung eines generischen Repositories.
 * 
 * @author theism
 * @version 1.0
 * @since Release 2016.1
 */
@Stateless
public class GenericRepository extends AbstractGenericRepository {

	/**
	 * Konkreter PersistenceContext für eine bestimmte PersistenceUnit
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @see edu.hm.cs.fwp.cloud.common.persistence.jpa.repository.AbstractGenericRepository#getEntityManager()
	 */
	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
