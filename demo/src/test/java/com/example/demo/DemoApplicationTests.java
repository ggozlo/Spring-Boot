package com.example.demo;

import com.example.demo.domain.PostDomain;
import com.example.demo.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PostRepository repository;

	@Test
	@Transactional
	void contextLoads() {
		PostDomain domain = new PostDomain();
		domain.setTitle("aa");
		domain.setContent("asdfgghh");

		repository.postSave(domain);
		Long id = domain.getId();
		PostDomain findDomain = repository.postFind(id);

		Assertions.assertThat(domain).isEqualTo(findDomain);

	}

}
