package com.hms.usermanagement;

import com.hms.user.manage.repository.UserRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermanagementApplicationTests {
	UserRepositoryImpl userRepository = new UserRepositoryImpl();


	@Test
	public void testaddUser() {


	}

}
