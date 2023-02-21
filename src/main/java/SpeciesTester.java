
import java.util.List;

import controller.SpeciesHelper;
import model.Species;

/**
 * @author Abigail Boggs - amboggs
 * CIS175 - Spring 2023
 * Feb 20, 2023
 */

/**
 * @author abbyb
 *
 */
public class SpeciesTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Species giraffe = new Species("giraffe");
		SpeciesHelper sh = new SpeciesHelper();
		
		sh.insertSpecies(giraffe);
		List<Species> allSpecies = sh.showAllSpecies();
		
		for(Species a : allSpecies) {
			System.out.println(a.toString());
		}

		
	}

}
