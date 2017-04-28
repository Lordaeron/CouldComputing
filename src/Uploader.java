

import java.io.IOException;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Uploader
 */
@WebServlet("/Uploader")
@MultipartConfig(fileSizeThreshold = 1024*1024*2,
				maxFileSize = 1024*1024*10,
				maxRequestSize = 1024*1024*50)
public class Uploader extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "uploadedFiles";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uploader() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String extractFileName(Part part){
    	String contentDisp = part.getHeader("content－disposition");
    	String[] item = contentDisp.split(";");
    	for (String s : item){
    		if(s.trim().startsWith("filename")){
    			return s.substring(s.indexOf("=")+2, s.length()-1);
    		}
    	}
    	return "";
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
		
		//获取当前app的绝对路径
		String appPath = request.getServletContext().getRealPath("");
		
		//创建上传app的存储路径
		String savePath = appPath+File.separator+SAVE_DIR;
		
		//创建存储目录
		File fileSaveDir = new File(savePath);
		
		if(!fileSaveDir.exists())
			fileSaveDir.mkdir();
		
		//分部上传文件
		for(Part part : request.getParts()){
			String fileName = extractFileName(part);
			part.write(savePath + File.separator + fileName);
		}
		
		System.out.println("upload ok");
		
		//解压
		Extractor ex = new Extractor();
		//需要当前jar路径和解压路径
		ex.unpack(savePath, savePath);
		doGet(request, response);
	}

}
