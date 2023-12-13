package com.goit.eugene.to_do_list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ToDoListApplication {
	public static void main(String[] args) {
				SpringApplication.run(ToDoListApplication.class, args);

	}

}
