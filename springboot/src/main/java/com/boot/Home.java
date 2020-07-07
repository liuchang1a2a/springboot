package com.boot;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boot.model.User;

/**
 *	入口类
 */

//@ImportResource({"classpath:context.xml"})	引入xml
@RestController
@EnableTransactionManagement		// 开启事务
@SpringBootApplication
public class Home {
	
	@RequestMapping("/home")
	public String welcome(HttpServletRequest req,HttpServletResponse res){
		return "WELCOME TO SPRINGBOOT 刘畅";
	}
	
	@Autowired
	private User user;
	
	@RequestMapping("/user")
	public String user(HttpServletRequest req,HttpServletResponse res){
		return user.toString();
	}
	
	@Value("${user.username}")
	private String username;
	
	@RequestMapping("/username")
	public String username() {
		return username;
	}
	
	public static void main(String[] args) {
		SpringApplication boot = new SpringApplication(Home.class);
		//banner: http://patorjk.com/software/taag
		boot.setBannerMode(Mode.OFF);	//关闭banner
		boot.run(args);
	}

}
