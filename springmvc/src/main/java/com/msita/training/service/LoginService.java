package com.msita.training.service;

import com.msita.training.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msita.training.dao.LoginDAO;
import com.msita.training.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//import com.msita.training.vo.User;

@Service
public class LoginService  {

	@Autowired
	private LoginDAO loginDAO;

	public User login(String username, String pass) {
		User rs=null;
		User user=loginDAO.login(username);
		System.out.println("order size: " +user.getListOrder().size());
		if(user!=null && user.getPassword().equals(pass)) {
			rs=user;
		}
		return rs;
	}
//
	public void updates(String pass, String username) throws ServletException, IOException {
		loginDAO.updates(pass,username);
	}
	public  void save(String username, String pass, String fullname){
		loginDAO.save(username, pass, fullname);

	}
}
