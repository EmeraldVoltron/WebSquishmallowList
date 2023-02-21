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
 * Feb 21, 2023
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
		Species cat = new Species("cat");
		SquishDetailsHelper sdh = new SquishDetailsHelper();
		Squishmallow corinne = new Squishmallow("Corinne", "Regular", "12");
		Squishmallow tally = new Squishmallow("Tally", "Regular", "5");
		
		List<Squishmallow> catsSquish = new ArrayList<Squishmallow>();
		catsSquish.add(corinne);
		catsSquish.add(tally);
				

		SquishDetails catsList = new SquishDetails("Cats List", cat);
		catsList.setListOfSquish(catsSquish);
		
		sdh.insertNewSquishListDetails(catsList);
		
		List<SquishDetails> allLists = sdh.getLists();
		
		for(SquishDetails a : allLists) {
			System.out.println(a.toString());
		}
		

	}

}
