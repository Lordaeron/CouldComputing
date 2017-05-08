

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String errMsg = ""; //设置错误提示，后面补
    	RequestDispatcher rd;
    	HttpSession ses = request.getSession(true);
    	String email = ses.getAttribute("email").toString();
    	String displayname = request.getParameter("username");
    	String email1 = request.getParameter("email");
    	//String password = request.getParameter("password");
    	String first_name = request.getParameter("firstname");
    	String last_name = request.getParameter("lastname");
    	String address = request.getParameter("address");
    	String postcode = request.getParameter("postcode");
    	String about = request.getParameter("aboutme");
    	ses.setAttribute("displayname", displayname);
    	Database db = new Database();
    	db.changeProfile(email1,email, displayname, first_name, last_name, address, postcode, about);
    	
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
