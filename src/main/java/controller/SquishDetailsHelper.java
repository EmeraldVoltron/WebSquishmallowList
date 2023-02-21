/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SquishDetails;
import model.Squishmallow;

/**
 * @author abbyb
 *
 */
public class SquishDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebSquishmallowList");
	
	public void insertNewSquishListDetails(SquishDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<SquishDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<SquishDetails> allDetails = em.createQuery("SELECT d FROM SquishDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(SquishDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SquishDetails> typedQuery = em.createQuery("select detail from SquishDetails detail where detail.id = :selectedId", SquishDetails.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		
		SquishDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public SquishDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SquishDetails found = em.find(SquishDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(SquishDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
