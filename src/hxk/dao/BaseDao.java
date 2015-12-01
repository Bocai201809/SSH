package hxk.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Class<T> entityClass;
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 通过反射获取子类确定的泛型类
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}
	
	//查找并返回子类序列号id的对象
	@SuppressWarnings("unchecked")
	public T get(Serializable id){
	    return (T)getSession().get(entityClass, id);
	}
	
	//添加一条记录
	public void save(Serializable entity){
		getSession().save(entity);
	}
	
	 /**
	     * @description 批量添加某对象的信息	
	     * @param serializables
	     *2013-9-1  下午10:35:47
	     *返回类型:void
	 */
	public void saveList(List<Serializable> serializables){
	    for (int i = 0; i < serializables.size(); i++) {
		    save(serializables.get(i));
		    // 批插入的对象立即写入数据库并释放内存  
	            if (i % 10 == 0) {  
	        	getSession().flush();
	        	getSession().clear();
	            }  
		}
	 }
	
	
	//删除PO
	public void delete(T entity){
		getSession().delete(entity);
	}
	
	
	//更新ＰＯ
	public void update(T entity){
		getSession().update(entity);
	}
	
	//根据hql语句查询,返回list
	@SuppressWarnings({ "rawtypes" })
	public List find(String hql){
		return  getSession().createQuery(hql).list();
	}
	
	//传带不定参数的hql语句来查询,返回list对象
	@SuppressWarnings("rawtypes")
	public List find(String hql,Object...objects){
		Query query=getSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}
	
	//根据传过来的一个参数和一个参数值来查找
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String property,Object value){
		String hql="from "+entityClass.getSimpleName()+" where "
				+property+" = ?";
		return getSession().createQuery(hql).setParameter(0, value).list();
		
	}
	
	//利用泛型寻找子类相对应的表的所有对象
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		String hql=" from "+entityClass.getSimpleName();
		return getSession().createQuery(hql).list();
	}
	
	//根据传过来的表属性,首条记录和记录数来选择东东
	@SuppressWarnings("unchecked")
	public List<T> findByBeansPages(String property,int firstResult,int maxResults){
		String hql=" from "+entityClass.getSimpleName()
				+" where "+property+" between ? and ? ";
		return getSession().createQuery(hql)
				.setParameter(0, firstResult)
				.setParameter(1, firstResult+maxResults-1).list();
	}
	
	//TODO分页 limit ? ,?
	

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		Session session=sessionFactory.getCurrentSession();
		return session;
	}

}
