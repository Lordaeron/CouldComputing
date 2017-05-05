

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
		//doGet(request, response);
		Database db = new Database();
		String getUsername = "";
		
		getUsername = request.getParameter("getUsername");
		if(getUsername!=null && getUsername.length()>0){
			String username;
			username = db.getDisplayName(getUsername);
			response.getWriter().write(username);
		}
		
		String getFirstname = "";
		getFirstname = request.getParameter("getFirstname");
		if(getFirstname!=null && getFirstname.length()>0){
			String firstname;
			firstname = db.getFirstName(getFirstname);
			response.getWriter().write(firstname);
		}
		
		String getLastname ="";
		getLastname = request.getParameter("getLastname");
		if(getLastname!=null && getLastname.length()>0){
			String lastname;
			lastname = db.getLastName(getLastname);
			response.getWriter().write(lastname);
		}
		
		String getCurrent ="";
		getCurrent = request.getParameter("getCurrent");
		System.out.println(getCurrent);
		int resCurrent;
		if(getCurrent != null && getCurrent.length()>0){
			resCurrent = db.getCurrent(getCurrent);
			System.out.println(resCurrent);
			response.getWriter().write(String.valueOf(resCurrent));
		}
		
		String changeCurrent ="";
		String tCurrent ="";
		int change =0;
		changeCurrent = request.getParameter("changeCurrent");
		tCurrent = request.getParameter("change");
		if(changeCurrent!=null && changeCurrent.length()>0 && tCurrent !=null && tCurrent.length()>0){
			change = Integer.parseInt(tCurrent);
			db.setCurrent(changeCurrent, change);
			int current;
			current = db.getCurrent(changeCurrent);
			response.getWriter().write(String.valueOf(current));
		} 
		
	}

}
