package com.boot;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.boot.model.User;

/**
 *	入口类
 */
@EnableAutoConfiguration
//@ImportResource({"classpath:context.xml"})	引入xml
@RestController
@ComponentScan
public class Home {
	
	@RequestMapping("/home")
	public String welcome(HttpServletRequest req,HttpServletResponse res){
		return "WELCOME TO SPRINGBOOT";
	}
	
	@Autowired
	User user;
	
	@RequestMapping("/user")
	public String user(HttpServletRequest req,HttpServletResponse res){
		return user.toString();
	}
	
	public static void main(String[] args) {
		SpringApplication boot = new SpringApplication(Home.class);
		//banner: http://patorjk.com/software/taag
		boot.setBannerMode(Mode.OFF);	//关闭banner
		boot.run(args);
	}

}
