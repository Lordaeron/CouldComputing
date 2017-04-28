import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Extractor {
	public void unpack(String jarPath, String destDir){
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
}
