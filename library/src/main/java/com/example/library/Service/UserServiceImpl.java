package com.example.library.Service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Dao.UserDaoJDBC;
import com.example.library.Entity.MyException;
import com.example.library.Entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDaoJDBC userdaojdbc;
	
	@Override
	public void signup(User user) throws MyException {
		User userinfo = userdaojdbc.findUserByPhoneNumber(user.getPhoneNumber());
		if (userinfo == null) {
			String passwd = user.getPassword();
			String enpasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
			user.setPassword(enpasswd);
			userdaojdbc.insertNewUser(user);
			
		}else {
			throw new MyException("0004","手機號碼已存在");
		} 
		
	}
	
	@Override
	public User login(User user) throws MyException {
		User userinfo = userdaojdbc.findUserByPhoneNumber(user.getPhoneNumber());
		if(userinfo!= null) {
			if (BCrypt.checkpw(user.getPassword(), userinfo.getPassword())) {
				return userinfo;
			}else {
				return null;
			}
		
		}
		return userinfo;
			
	}


	
}
