package com.example.crud3;

import com.example.crud3.domain.Phone;
import com.example.crud3.domain.User;
import com.example.crud3.repository.PhoneRepository;
import com.example.crud3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Crud3Application {


	public static void main(String[] args)
	{
		SpringApplication.run(Crud3Application.class, args);
	}


}
