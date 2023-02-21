package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Species;
import model.SquishDetails;
import model.Squishmallow;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListSquishmallowHelper lsh = new ListSquishmallowHelper();
		String listName = request.getParameter("speciesListName");
		System.out.println("List name: " + listName);
		
		String speciesName = request.getParameter("speciesName");
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<Squishmallow> selectedItemsInList = new ArrayList<Squishmallow>();
		if(selectedItems !=null && selectedItems.length > 0) {
			for(int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Squishmallow c = lsh.searchForSquishById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		Species species = new Species(speciesName);
		SquishDetails sd = new SquishDetails(listName, species);
		
		sd.setListOfSquish(selectedItemsInList);
		SquishDetailsHelper sdh = new SquishDetailsHelper();
		sdh.insertNewSquishListDetails(sd);
		
		System.out.println("Success!");
		System.out.println(sdh.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
