

import java.util.ArrayList;
import java.util.List;

import controller.SpeciesHelper;
import controller.SquishDetailsHelper;
import model.Species;
import model.SquishDetails;
import model.Squishmallow;

/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 20, 2023
 */

/**
 * @author abbyb
 *
 */
public class SquishDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Species dog = new Species("Dog");
		SpeciesHelper sh = new SpeciesHelper();
		
		sh.insertSpecies(dog);
		SquishDetailsHelper sdh = new SquishDetailsHelper();
		
		SquishDetails dogsList = new SquishDetails("Dog's List", dog);
		sdh.insertNewSquishListDetails(dogsList);
		
		List<SquishDetails> allLists = sdh.getLists();
		
		for(SquishDetails a : allLists) {
			System.out.println(a.toString());
		}
		
	}

}
