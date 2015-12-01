package hxk.action;

import hxk.model.User;
import hxk.service.UserService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 * @description
 *2015-11-30  下午8:17:22
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction{
    private static final long serialVersionUID = -5745576864598397002L;
    
    @Resource
    private UserService userService;
    
    //拿来ajax传值的..
    private String pwd;
    
    //excel下载的路径
    private String path = "d:/test.xlsx";		
    


    /**
     * @description 测试最简单的SSH入门
     * 	只是单纯的读取出来值	
     * @return
     *2015-11-30  下午8:52:13
     *返回类型:String
     */
    public String index(){
	List<User> users = userService.getAll();
	request.put("users", users);
	return "index";
    }
    
    /**
     * @description struts实现ajax的方式	
     * @return
     *2015-11-30  下午9:11:03
     *返回类型:String
     */
    public String ajaxPwd(){
	User user = userService.getUserById("tinys");
	pwd = user.getPwd();
	return "ajax";
    }
    
    
    /**
     * @description struts提供的下载	
     * @return
     *2015-11-30  下午10:36:59
     *返回类型:String
     */
    public String download(){
	return "download";
    }
    
    
    
    
    
    /*
                定义一个返回InputStream的方法，
                该方法将作为被下载文件的入口，
                且需要配置stream类型结果时指定inputName参数，inputName参数的值就是方法去掉get前缀、首字母小写的字符串
    */
    public InputStream getTargetFile() throws Exception
    {
        //ServletContext提供getResourceAsStream()方法
        //返回指定文件对应的输入流
        return new FileInputStream(new File(path));
    }

    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getPwd() {
        return pwd;
    }

    
    
}
