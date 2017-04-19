package com.niit.shoppingcart.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.Register;



@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	  Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
		 
		@Autowired
		private SessionFactory sessionFactory;


		public UserDAOImpl(SessionFactory sessionFactory) {
			try {
				this.sessionFactory = sessionFactory;
			} catch (Exception e) {
				log.error(" Unable to connect to db");
				e.printStackTrace();
			}
		}

		@Transactional
		public List<Register> list() {
			@SuppressWarnings("unchecked")
			List<Register> list = (List<Register>) sessionFactory.getCurrentSession()
					.createCriteria(Register.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			return list;
		}

		@Transactional
		public void save(Register Register) {
			sessionFactory.getCurrentSession().save(Register);
		}
		
		@Transactional
		public void delete(int id) {
			Register Register = new Register();
			Register.setId(id);
			sessionFactory.getCurrentSession().delete(Register);
		}

		@Transactional
		public Register get(int id) {
			String hql = "from Register where id=" + "'"+ id+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Register> list = (List<Register>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			
			return null;
		}
		
		@Transactional
		public boolean isValidRegister(int id, String password) {
			String hql = "from Register where id= '" + id + "' and " + " password ='" + password+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Register> list = (List<Register>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return true;
			}
			
			return false;
		}

		public void update(Register Register) {
			sessionFactory.getCurrentSession().update(Register);
			
		}

		@Transactional
		public void saveorUpdate(Register registeruser) {
			sessionFactory.getCurrentSession().saveOrUpdate(registeruser);
			
		}
		@Transactional
		public void saveorUpdate(User loginuser)
		{
			sessionFactory.getCurrentSession().saveOrUpdate(loginuser);
		}
		@Transactional

		public User getSingleUser(int id) {
			Session session = sessionFactory.openSession();
			User user = (User) session.load(User.class, id);
			return user;
		}
		@Transactional

		public List getAllUsers() {
			Session session = sessionFactory.openSession();
			List list = session.createQuery("from Authorities").list();
			System.out.println(list);
			System.out.println(list());
			session.close();
			return list;
		}
		@Transactional
		public void update(User editlogin) {
			sessionFactory.getCurrentSession().update(editlogin);
			
		}

		 

	}
