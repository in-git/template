package com.init.module.index.center;

import java.util.HashMap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.config.shiro.JwtUtil;
import com.init.module.index.bean.Users;
import com.init.module.index.mapper.UserDao;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("public")
@Slf4j
public class Center {
	@Autowired
	UserDao userDao;

	@GetMapping("/login")
	public Object login(Users users) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getPassword());
		try {
			subject.login(token);
			HashMap<String, String> info = new HashMap<>();
			info.put("username", users.getUsername());
			JwtUtil.generator(info);
		} catch (UnknownAccountException e) {
		} catch (DisabledAccountException e) {
		} catch (IncorrectCredentialsException e) {
		} catch (AuthenticationException e) {
		} catch (Throwable e) {
		}
		return null;
	}

	@GetMapping("/register")
	public void register(Users user) {
		// 生成盐值
		String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
		String ciphertext = new Md5Hash(user.getPassword(), salt, 3).toString();
// 		 类型转换
		user.setSalt(salt);
		user.setPassword(ciphertext);
// 		 放进数据库
		userDao.insert(user);
	}

	@Autowired

	@GetMapping("/getSession")
	public Object getSession() {
		return null;
	}
}
