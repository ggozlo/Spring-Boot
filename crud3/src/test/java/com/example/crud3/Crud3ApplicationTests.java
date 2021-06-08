package com.example.crud3;

import com.example.crud3.domain.Phone;
import com.example.crud3.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
class Crud3ApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Test
	@Transactional
	@Rollback(value = false)
	void contextLoads() {

		User first = new User("한라산");
		User second = new User("홍길동");
		Phone phone2 = new Phone("010-1111-1111");
		Phone phone1 = new Phone("010-1111-1112");
		Phone phone = new Phone("010-1111-1113");

		first.addPhone(phone);
		first.addPhone(phone1);
		first.addPhone(phone2);
		second.addPhone(phone1);
		second.addPhone(phone2);


//		User second = new User("명지산");
//		second.addPhone(new Phone("010-2222-2222"));
//		second.addPhone(new Phone("010-2222-2223"));
//
//		User third = new User("광교산");
//		third.addPhone(new Phone("010-3333-3333"));

		entityManager.persist(first);
		entityManager.persist(second);
		entityManager.persist(phone);
		entityManager.persist(phone1);
		entityManager.persist(phone2);


		entityManager.flush();
		entityManager.clear();




	}

}
