/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Species;

/**
 * @author abbyb
 *
 */
public class SpeciesHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebSquishmallowList");
	
	public void insertSpecies(Species s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Species> showAllSpecies(){
		EntityManager em= emfactory.createEntityManager();
		List<Species> allSpecies = em.createQuery("SELECT s FROM Species s").getResultList();
		return allSpecies;
	}
	
	public Species findSpecies(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Species> typedQuery = em.createQuery("select sh from Species sh where sh.speciesName = :selectedName", Species.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Species foundSpecies;
		try {
			foundSpecies = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundSpecies = new Species(nameToLookUp);
		}
		em.close();
		return foundSpecies;
	}
}
