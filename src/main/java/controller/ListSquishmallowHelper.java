/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Jan 31, 2023
 */
package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Squishmallow;

/**
 * @author abbyb
 *
 */


public class ListSquishmallowHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebSquishmallowList");
	
	public void insertSquishmallow(Squishmallow squish) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(squish);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Squishmallow> showCollection() {
		EntityManager em = emfactory.createEntityManager();
		List<Squishmallow> allSquish = em.createQuery("SELECT i FROM Squishmallow i").getResultList();
		return allSquish;
	}
	
	public void deleteItem(Squishmallow toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Squishmallow> typedQuery = em.createQuery("select squish from Squishmallow squish where squish.name = "
				+ ":selectedName and squish.type = :selectedType and squish.size = :selectedSize", Squishmallow.class);
		
		//setting parameters to delete
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedSize", toDelete.getSize());
		
		//only want one result
		typedQuery.setMaxResults(1);
		
		//get result and save it into a list item
		Squishmallow result = typedQuery.getSingleResult();
		
		//remove squishmallow
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	

	/**
	 * @param squishName
	 * @return
	 */
	public List<Squishmallow> searchForSquishByName(String squishName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Squishmallow> typedQuery = em.createQuery("select squish from Squishmallow squish where squish.name = :selectedName", Squishmallow.class);
		typedQuery.setParameter("selectedName", squishName);
		
		List<Squishmallow> foundSquish = typedQuery.getResultList();
		em.close();
		return foundSquish;
	}

	/**
	 * @param squishType
	 * @return
	 */
	public List<Squishmallow> searchForSquishByType(String squishType) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Squishmallow> typedQuery = em.createQuery("select squish from Squishmallow squish where squish.type = :selectedType", Squishmallow.class);
		typedQuery.setParameter("selectedType", squishType);
		
		List<Squishmallow> foundSquish = typedQuery.getResultList();
		em.close();
		return foundSquish;
	}
	
	/**
	 * @param squishSize
	 * @return
	 */
	public List<Squishmallow> searchForSquishBySize(String squishSize) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Squishmallow> typedQuery = em.createQuery("select squish from Squishmallow squish where squish.size = :selectedSize", Squishmallow.class);
		typedQuery.setParameter("selectedSize", squishSize);
		
		List<Squishmallow> foundSquish = typedQuery.getResultList();
		em.close();
		return foundSquish;
	}
	
	public Squishmallow searchForSquishById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Squishmallow found = em.find(Squishmallow.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateSquish(Squishmallow toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
