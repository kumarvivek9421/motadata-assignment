package com.example.user;
import com.example.user.entities.User;
import com.example.user.repositories.UserRepository;
import com.example.user.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserApplicationTests {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	void createUser_Success(){
		User user= new User("vivek kumar", "vivek@gmail.com");
		when(userRepository.save(user)).thenReturn(user);

		User result= userService.createUser(user);
		
	}

}
