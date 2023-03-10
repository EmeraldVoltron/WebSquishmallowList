package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Squishmallow;

/**
 * Servlet implementation class editSquishServlet
 */
@WebServlet("/editSquishServlet")
public class editSquishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSquishServlet() {
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
		ListSquishmallowHelper dao= new ListSquishmallowHelper();
		
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String size = request.getParameter("size");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Squishmallow squishToUpdate = dao.searchForSquishById(tempId);
		squishToUpdate.setName(name);
		squishToUpdate.setSize(size);
		squishToUpdate.setType(type);
		
		dao.updateSquish(squishToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllSquishServlet").forward(request, response);
		
	}

}
