package hxk.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 * @description 主要用来实现上传文件
 *2015-12-1  下午8:56:33
 */
@Controller("uploadAction")
@Scope("prototype")
public class UploadAction extends BaseAction{
    private static final long serialVersionUID = 3517475157555108650L;
    
    private File file;		//上传过来的文件
    private String fileContentType; // 封装上传文件类型的属性
    private String fileFileName; // 封装上传文件名的属性
    
    
    
    public String up(){
	//获取真实的request
	HttpServletRequest request = ServletActionContext.getRequest ();
	//获取真实的路径
	String path = request.getServletContext().getRealPath("/"); 
	//传统的读写文件..现在基本使用copyFile就好
	File files = new File(path+"/upload/test.xls");
	BufferedInputStream in = null;
	BufferedOutputStream out = null;
	try {
	    if (files.exists()) {
		files.createNewFile();
	    }
	    InputStream input = new FileInputStream(file);
	    in = new BufferedInputStream(input);
	    out = new BufferedOutputStream(new FileOutputStream(files));
	    int length = -1;
	    byte[] buffer = new byte[1024];
	    while ((length = in.read(buffer)) !=-1) {
		out.write(buffer, 0, length);
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	finally{
	    try {
		out.flush();
		out.close();
		in.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	
	return "upload";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }
    public String getFileContentType() {
        return fileContentType;
    }
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
    public String getFileFileName() {
        return fileFileName;
    }
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
    
    

}
