

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DatabaseAPI
 */
@WebServlet("/DatabaseAPI")
public class DatabaseAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseAPI() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		Database db = new Database();
		String getUsername;
		
		getUsername = request.getParameter("getUsername");
		if(getUsername.length() !=0){
			String username;
			username = db.getDisplayName(getUsername);
			response.getWriter().write(username);
		}
		
		String getFirstname;
		getFirstname = request.getParameter("getFirstname");
		if(getFirstname.length() !=0){
			String firstname;
			firstname = db.getFirstName(getFirstname);
			response.getWriter().write(firstname);
		}
		
		String getLastname;
		getLastname = request.getParameter("getLastname");
		if(getLastname.length() !=0){
			String lastname;
			lastname = db.getLastName(getLastname);
			response.getWriter().write(lastname);
		}
		
		String getCurrent;
		getCurrent = request.getParameter("getCurrent");
		int resCurrent;
		if(getCurrent.length() !=0){
			resCurrent = db.getCurrent(getCurrent);
			response.getWriter().write(resCurrent);
		}
		
		String changeCurrent;
		int change;
		changeCurrent = request.getParameter("changeCurrent");
		change = Integer.parseInt(request.getParameter("change"));
		if(changeCurrent.length() * change !=0){
			db.setCurrent(changeCurrent, change);
			int current;
			current = db.getCurrent(changeCurrent);
			response.getWriter().write(current);
		} 
		
	}

}
