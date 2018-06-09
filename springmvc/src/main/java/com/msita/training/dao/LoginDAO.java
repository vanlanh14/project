package com.msita.training.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.msita.training.entity.User;

//import com.msita.training.vo.User;

@Repository

public class LoginDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public User login(String username) {
//		User user = getJdbcTemplateObject().query(
//				"SELECT iduser,password,name,idrole from user where iduser=?",
//				new PreparedStatementSetter() {
//
//					@Override
//					public void setValues(PreparedStatement arg0) throws SQLException {
//						arg0.setString(1, username);
//					}
//				}, new ResultSetExtractor<User>() {
//					@Override
//					public User extractData(ResultSet ret) throws SQLException, DataAccessException {
//						User user = null;
//						if(ret.next()) {
//							user = new User();
//							user.setUsername(ret.getString("iduser"));
//							user.setPassword(ret.getString("password"));
//							user.setFullName(ret.getString("name"));
//							user.setRole(ret.getString("idrole"));
//						}
//						return user;
//					}
//				});
//

		return (User) sessionFactory.getCurrentSession().get(com.msita.training.entity.User.class, username);
	}
	@Transactional
	public void updates(String pass, String username)throws ServletException, IOException {
		User user = login(username);
		user.setPassword(pass);
		try {
			sessionFactory.getCurrentSession().update(user);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	@Transactional
	public void save(String username, String pass, String fullname){
			User user = new User();
			user.setUsername(username);
			user.setPassword(pass);
			user.setFullname(fullname);
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);

	}
}