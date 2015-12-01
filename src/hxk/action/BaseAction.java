package hxk.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 * @description
 *2015-11-30  下午8:18:18
 */
public class BaseAction extends ActionSupport implements RequestAware,SessionAware, ApplicationAware{
    private static final long serialVersionUID = -3939375184839618747L;
    
    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String, Object> application;
    
    


    public void setRequest(Map<String, Object> request) {
	this.request = request;
    }
     
    public void setSession(Map<String, Object> session) {
	this.session = session;
    }
    
    public void setApplication(Map<String, Object> application) {
	this.application = application;
    }
    
    public Map<String, Object> getRequest() {
	return request;
    }
    
    public Map<String, Object> getSession() {
	return session;
    }
    
    public Map<String, Object> getApplication() {
   	return application;
    }

}
