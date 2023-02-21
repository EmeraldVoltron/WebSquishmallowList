/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author abbyb
 *
 */
@Entity
public class SquishDetails {
	@Id
	@GeneratedValue
	private int id;
	private String speciesListName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Species species;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Squishmallow> listOfSquish;
	
	public SquishDetails() {
		super();
	}
	
	public SquishDetails(int id, String speciesListName, Species species, List<Squishmallow> listOfSquish) {
		this.id=id;
		this.speciesListName = speciesListName;
		this.species = species;
		this.listOfSquish = listOfSquish;
	}
	
	public SquishDetails(String speciesListName, Species species, List<Squishmallow> listOfSquish) {
		this.speciesListName = speciesListName;
		this.species = species;
		this.listOfSquish = listOfSquish;
	}
	
	public SquishDetails(String speciesListName, Species species) {
		this.speciesListName = speciesListName;
		this.species = species;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the speciesListName
	 */
	public String getSpeciesListName() {
		return speciesListName;
	}

	/**
	 * @param speciesListName the speciesListName to set
	 */
	public void setSpeciesListName(String speciesListName) {
		this.speciesListName = speciesListName;
	}

	/**
	 * @return the species
	 */
	public Species getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(Species species) {
		this.species = species;
	}

	/**
	 * @return the listOfSquish
	 */
	public List<Squishmallow> getListOfSquish() {
		return listOfSquish;
	}

	/**
	 * @param listOfSquish the listOfSquish to set
	 */
	public void setListOfSquish(List<Squishmallow> listOfSquish) {
		this.listOfSquish = listOfSquish;
	}

	@Override
	public String toString() {
		return "SquishDetails [id=" + id + ", speciesListName=" + speciesListName + ", species=" + species
				+ ", listOfSquish=" + listOfSquish + "]";
	}
	
	
}
