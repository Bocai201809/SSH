package hxk.interceptor;

import java.util.Map;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {
        private static final long serialVersionUID = 1L;
        
        @Override
        public void destroy() {}
        
        @Override
        public void init() {}
        
        @Override
        public String intercept(ActionInvocation invocation) throws Exception {
            System.out.println("begin-------------------------------");  
            //找到运行的Action对象，并打印其类名  
            System.out.println("Action:"+invocation.getAction().getClass().getName());  
            //找到运行的ActionProxy对象，并打印其要运行的方法名  
            System.out.println("Method:"+invocation.getProxy().getMethod());  
            //找到这次请求的request中的parameter参数，并打印  
            Map<String, Object> params = invocation.getInvocationContext().getParameters();  
            for (String key:params.keySet()){  
                Object obj = params.get(key);  
                if(obj instanceof String[]){  
                    String[] arr = (String[]) obj;  
                    System.out.println("Param:"+key);  
                    for (String value:arr){  
                        System.out.println(value);  
                    }  
                }  
            }  
              
            //运行后续的拦截器、Action和Result  
            String resultCode = invocation.invoke();  
              
            //在Action和Result运行之后，得到Result对象  
            //并且可以强制转换成ServletDispatcherResult，打印其下一个JSP的位置  
            Result rresult = invocation.getResult();  
            if (rresult instanceof ServletDispatcherResult){  
                ServletDispatcherResult result = (ServletDispatcherResult) rresult;  
                System.out.println("JSP:"+result.getLastFinalLocation());  
            }  
              
            System.out.println("end-------------------------------");          
            return resultCode;  
           }
        

}
