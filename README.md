# SSH

###这是一个SSH的简单Demo..

####主要提供了以下功能 :  

1.最简单的入门struts控制器做controller例子   

2.使用struts的返回json例子 

3.一个下载文件的例子

4.一个上传文件的例子

5.配置拦截器..提供了一个实用的日志记录器..方便查看..如下.. 


     `begin------------------------------- 
     
     ` Action:hxk.action.UserAction 
     
     `Method:index 
     
     `Hibernate:  
     
     `   select 
     
     `        user0_.name as name0_, 
     
     `       user0_.age as age0_, 
     
     `       user0_.pwd as pwd0_  
     
     `  from 
     
     `       user user0_ 
     
    ` JSP:/jsp/user/index.jsp 
    
    `end------------------------------- 
    
    `begin------------------------------- 
    `Action:hxk.action.UserAction 
    `Method:ajaxPwd 
    `Hibernate:  
    `   select 
    `        user0_.name as name0_0_, 
    `        user0_.age as age0_0_,
    `        user0_.pwd as pwd0_0_ 
    `    from
    `        user user0_ 
    `    where
    `        user0_.name=?
    `end-------------------------------
