package com.vtxlab.bootcamp.bootcampbeanconfig;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // A test env. -> Spring Context
// Ensure all beans are available in this env.
class BootcampBeanConfigApplicationTests {

	@Test // check all dependencies before creating the beans
	void contextLoads() {
		
	}

}
