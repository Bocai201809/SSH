package hxk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import hxk.model.User;

/**
 * @author Administrator
 * @description
 *2015-11-27  下午9:32:04
 */
@Repository
public class UserDao extends BaseDao<User>{
    private static final long serialVersionUID = -8172262557723268145L;

    @SuppressWarnings("unchecked")
    public List<User> getUserByAge(int age){
	String hql = "from User u where u.age = :age";
	return getSession().createQuery(hql).list();
    }
}
