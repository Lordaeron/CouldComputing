

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String errMsg = "";
		RequestDispatcher rd;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email+password);
		Database db = new Database();
		boolean flag;
		flag = false;
		flag = db.checkPassword(email, password);
		System.out.println(flag);
		//flag = true;
		if(flag){
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			System.out.println(session);
			rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		}
		else{
			System.out.println("fail");
			rd = request.getRequestDispatcher("/login.html");
			request.setAttribute("err", errMsg);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
