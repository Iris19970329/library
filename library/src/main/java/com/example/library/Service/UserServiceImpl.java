package com.example.library.Service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Dao.IUserDao;
import com.example.library.Entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userdao;
	
	@Override
	public User signup(User user){
		List<User> userinfo = userdao.findByPhoneNumber(user.getPhoneNumber());
		if (userinfo.isEmpty()) {
			String passwd = user.getPassword();
			String enpasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
			user.setPassword(enpasswd);
			return userdao.save(user);
			
		}else {
			throw new IllegalArgumentException("手機號碼已存在");
		} 
		
	}
	
	@Override
	public int login(User user) {
		List<User> userdetail = userdao.findByPhoneNumber(user.getPhoneNumber());
		if(userdetail.isEmpty() ) {
			return 0;
		}else if(BCrypt.checkpw(user.getPassword(), userdetail.get(0).getPassword())) {
			return 1;
		}else {
			return 2;
		}
			
			
	}


	
}
