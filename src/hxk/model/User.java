package hxk.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 * @description
 *2015-11-27  下午9:20:09
 */
@Entity
@Table(name="user")
public class User {
    /**
      name  varchar(25) not null PRIMARY KEY,       
       pwd  varchar(32) not null,       
       age  int not null   
     */
    @Id
    private String name;
    
    private String pwd;
    
    private Integer age;
    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    
    
}
