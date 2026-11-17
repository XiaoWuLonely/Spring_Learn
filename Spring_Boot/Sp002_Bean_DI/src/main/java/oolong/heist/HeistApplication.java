package oolong.heist;

import oolong.heist.bean.User;
import oolong.heist.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HeistApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(HeistApplication.class, args);
		UserService serviceImpl = applicationContext.getBean("userServiceImpl", UserService.class);
		User user = serviceImpl.getUser();
		System.out.println(user);
		applicationContext.close();
	}

}
