import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Extractor {
	public void unpackJar(String jarPath, String destDir){
		try {
			JarFile jarfile = new JarFile(jarPath);
			for(Enumeration<JarEntry> iter = jarfile.entries(); iter.hasMoreElements();){
				JarEntry entry = iter.nextElement();
				System.out.println("Processing: "+ entry.getName());
				File outfile = new File(destDir,entry.getName());
				if(!outfile.exists()){
					//创建路径
					outfile.getParentFile().mkdirs();
				}
				
				if(!entry.isDirectory()){
					InputStream instream = jarfile.getInputStream(entry);
					System.out.println(outfile.getName()+outfile.getAbsoluteFile());
					FileOutputStream outstream = new FileOutputStream(outfile);
					while(instream.available()>0){
						outstream.write(instream.read());
					}
					outstream.close();
					instream.close();
				}
			}
			jarfile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void unpackZip(String zipPath,String destDir){
		boolean isSuccessful = true;
        try {
             BufferedInputStream bis = new BufferedInputStream(new FileInputStream(zipPath));
             ZipInputStream zis = new ZipInputStream(bis);

             BufferedOutputStream bos = null;

             //byte[] b = new byte[1024];
             ZipEntry entry = null;
             while ((entry=zis.getNextEntry()) != null) {
                  String entryName = entry.getName();
                  bos = new BufferedOutputStream(new FileOutputStream(destDir+entryName));
                  int b = 0;
                  while ((b = zis.read()) != -1) {
                       bos.write(b);
                  }
                  bos.flush();
                  bos.close();
             }
             zis.close();
        } catch (IOException e) {
             isSuccessful = false;
        }
	}
	public static synchronized void decompress(String projectName,String fileName,String outputPath){  
        
        if (!outputPath.endsWith(File.separator)) {  
            outputPath =outputPath+ File.separator+projectName+File.separator;  
        }  
        else{
        	outputPath = outputPath+projectName+File.separator;
        }
        File dir = new File(outputPath);  
        if (!dir.exists()) {  
            dir.mkdirs();  
        }  
        JarFile jf = null;  
    try{  
        jf =  new JarFile(fileName);  
        for (Enumeration<JarEntry> e = jf.entries(); e.hasMoreElements();) {  
            JarEntry je = (JarEntry) e.nextElement();  
            String outFileName = outputPath + je.getName();  
            File f = new File(outFileName);  
            if(je.isDirectory()){  
                if(!f.exists()){  
                    f.mkdirs();  
                }  
            }else{  
                File pf = f.getParentFile();  
                if(!pf.exists()){  
                    pf.mkdirs();  
                }  
                InputStream in = jf.getInputStream(je);  
                OutputStream out = new BufferedOutputStream(  
                        new FileOutputStream(f));  
                byte[] buffer = new byte[2048];  
                int nBytes = 0;  
                while ((nBytes = in.read(buffer)) > 0) {  
                    out.write(buffer, 0, nBytes);  
                }  
                out.flush();  
                out.close();  
                in.close();  
            }  
        }  
    }catch(Exception e){  
        System.out.println("error");  
    }finally{  
        if(jf!=null){  
            try {  
                jf.close();  
                File jar = new File(jf.getName());  
                if(jar.exists()){  
                    jar.delete();  
                    System.out.print("delete");
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  
}  

