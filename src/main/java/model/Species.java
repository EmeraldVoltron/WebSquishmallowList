/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 20, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author abbyb
 *
 */
@Entity
@Table(name="species")
public class Species {
	@Id
	@GeneratedValue
	private int id;
	private String speciesName;
	
	public Species() {
		super();
	}
	
	public Species(int id, String speciesName) {
		super();
		this.id=id;
		this.speciesName = speciesName;
	}
	
	public Species(String speciesName) {
		super();
		this.speciesName = speciesName;
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
	 * @return the speciesName
	 */
	public String getSpeciesName() {
		return speciesName;
	}

	/**
	 * @param speciesName the speciesName to set
	 */
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	@Override
	public String toString() {
		return "Species [id=" + id + ", speciesName=" + speciesName + "]";
	}
	
}
