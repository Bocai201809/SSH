package hxk.service;

import hxk.dao.UserDao;
import hxk.model.User;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @description
 *2015-11-30  下午8:13:08
 */
@Service
@Transactional(readOnly=true)
public class UserService {
    @Resource
    private UserDao userDao;
    
    public List<User> getAll(){
	return userDao.findAll();
    }
    
    public List<User> getUserByAge(int age){
	return userDao.findByProperty("age", age);
    }
    
    public User getUserById(String name){
	return userDao.get(name);
    }
}
