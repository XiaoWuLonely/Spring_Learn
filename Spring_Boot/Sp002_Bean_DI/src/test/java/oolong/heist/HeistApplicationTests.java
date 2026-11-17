package oolong.heist;

import oolong.heist.bean.User;
import oolong.heist.config.AppConfig;
import oolong.heist.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HeistApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		User user = userService.getUser();
		System.out.println(user);
	}

	@Autowired
	private AppConfig appConfig;

	@Test
	void test01(){
		appConfig.printInfo();
	}

}
