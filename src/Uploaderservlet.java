

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig; 
import javax.servlet.http.Part;
/**
 * Servlet implementation class Uploaderservlet
 */
@WebServlet("/Uploaderservlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10, // 10MB
maxRequestSize=1024*1024*50) // 50MB
public class Uploaderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
			return "";
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uploaderservlet() {
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
		String appPath = request.getServletContext().getRealPath(""); 
		System.out.println(appPath);
		// Create path to the directory to save uploaded file 
		String savePath = appPath;// + File.separator + SAVE_DIR;
		System.out.println(savePath);
		// Create the save directory if it does not exist
		File fileSaveDir = new File(savePath); 
		
		//从当前session 中获取用户主键值
		HttpSession session = request.getSession(true);
		String email = session.getAttribute("email").toString();
		
		String appName = request.getParameter("appname");
		String about = request.getParameter("aboutapp");
		//String appName = "123";
		//String about = "456";
		System.out.println(appName+about);
		
		if (!fileSaveDir.exists()) fileSaveDir.mkdir(); 
		String fileName = null;
		
			Part part  = request.getPart("file");
			fileName = extractFileName(part);
			part.write(savePath + File.separator + fileName); 
		// Add more code here to generate HTML response 
		// to say that upload was completed successfully
		//doGet(request, response);
		String path = savePath+File.separator +fileName;
		Database db = new Database();
		response.getWriter().append("upload sucess").append(savePath);
		
		Extractor ex = new Extractor();
		String projectName[] = fileName.split("\\.");
		String projectDir = "/Library/Tomcat/webapps";
		
		ex.decompress(projectName[0],path, "/var/lib/tomcat8/webapps");
		String path2 = projectDir + projectName[0];
		String name3 = projectName[0]; //解压路径
		
		db.uploadApp(appName, email,"/"+projectName[0],about);
		RequestDispatcher rd;
		System.out.println(projectName[0]);
		System.out.println(projectName[1]);
		
		db.setCurrent(email, 10);
		int current  = db.getCurrent(email);
		session.setAttribute("current", String.valueOf(current));
		
		rd = request.getRequestDispatcher("/main.jsp");
		rd.forward(request, response);
		
	}

}
