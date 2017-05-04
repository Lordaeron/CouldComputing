import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
}
