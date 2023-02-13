/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Jan 31, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author abbyb
 *
 */
@Entity
@Table(name="squishmallows")
public class Squishmallow {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id; //given squishmallow id
	@Column(name="SIZE")
	private String size; //size of squishmallow
	@Column(name="NAME")
	private String name; //squishmallow's name
	@Column(name="TYPE")
	private String type; //squishmallow's type - regular, stack, clip, hugmee, etc...
	
	
	//default constructor
	public Squishmallow(){
		
	}
	
	public Squishmallow(String name, String type, String size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	//return squishmallows detail, its size, name, and the type
	public String returnSquishmallowDetails() {
		return this.size + " inch " + this.name + ": " + this.type;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
