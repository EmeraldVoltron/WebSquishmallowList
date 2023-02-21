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
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SquishDetailsHelper dao = new SquishDetailsHelper();
		ListSquishmallowHelper lsh = new ListSquishmallowHelper();
		SpeciesHelper sh = new SpeciesHelper();
		
		Integer tempId=Integer.parseInt(request.getParameter("id"));
		SquishDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("speciesListName");
		String speciesName = request.getParameter("species");
		
		Species newSpecies = sh.findSpecies(speciesName);
		
		try{
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Squishmallow> selectedItemsInList = new ArrayList<Squishmallow>();
			
			for(int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Squishmallow c = lsh.searchForSquishById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			
			listToUpdate.setListOfSquish(selectedItemsInList);
		} catch(NullPointerException ex) {
			List<Squishmallow> selectedItemsInList = new ArrayList<Squishmallow>();
			listToUpdate.setListOfSquish(selectedItemsInList);
		}
		
		listToUpdate.setSpeciesListName(newListName);
		listToUpdate.setSpecies(newSpecies);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}

}
