

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   // store new user information into database
   private boolean storeDatabase (String first_name, String last_name, String displayname,
		   String email, String password){
	   Database db = new Database();
	   boolean flag;
	   flag = false;
	   flag = db.signup(email, password, first_name, last_name, displayname);
	   return flag;
   }
   
   //判断邮箱格式是否合法，合法返回true
   private boolean checkEmail(String email){
	   String checkEmail = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; 
   		Pattern regex = Pattern.compile(checkEmail);
   		Matcher matcher = regex.matcher(email);
   		boolean isMatch = matcher.matches();
   		return isMatch;
   }
   private String getMD5(String password){
	   MessageDigest md;
	try {
		md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		return new BigInteger(1, md.digest()).toString(16);
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return password;
   }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errMsg = ""; //设置错误提示，后面补
    	RequestDispatcher rd;
    	
    	//获取请求参数
    	String first_name = request.getParameter("first_name");
    	String last_name = request.getParameter("last_name");
    	String displayname = request.getParameter("displayname");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	System.out.println(first_name);
    	boolean check = checkEmail(email);
    	String md5 = getMD5(password);
    	// 判断邮箱格式是否合法
    	if(!check){
    		System.out.println("email pattern illegal");
    		return;
    	}
    	if(first_name.isEmpty()||last_name.isEmpty()||displayname.isEmpty()||email.isEmpty()||password.isEmpty()){
    		System.out.println("cannot be empty");
    		return;
    	}
    	boolean flag;
    	flag = storeDatabase(first_name,last_name,displayname,email,password);
    	if(flag){
    		
    		//将email作为主键存入session
    		HttpSession session = request.getSession(true);
    		session.setAttribute("email", email);
    		session.setAttribute("displayname", displayname);
    		Database db = new Database();
    		String current = String.valueOf(db.getCurrent(email));
			session.setAttribute("current", current);

    		System.out.println(session.getAttribute("email"));
    		System.out.println(session.getAttribute("displayname"));
    		Cookie cookiee = new Cookie("email",email);
    		Cookie cookied = new Cookie("displayname",displayname);
    		cookiee.setMaxAge(60*60*1000);
    		cookiee.setPath("/");
    		cookied.setMaxAge(60*60*1000);
    		cookied.setPath("/");
    		response.addCookie(cookiee);
    		response.addCookie(cookied);
    		rd = request.getRequestDispatcher("index.jsp");
        	rd.forward(request, response);
    	}
    	else{
    		rd = request.getRequestDispatcher("signup.jsp");
    		rd.forward(request, response);
    	}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
