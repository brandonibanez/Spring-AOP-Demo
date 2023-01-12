package com.example.SpringAOP;

import com.example.SpringAOP.dao.AccountDAO;
import com.example.SpringAOP.dao.MemberDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.logging.Logger;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopApplication {

	public static void main(String[] args) {

		var test = new SpringAopApplication();
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringAopApplication.class, args);

		var account = context.getBean(AccountDAO.class);
		var member = context.getBean(MemberDAO.class);

		account.listAccounts().forEach((a) -> System.out.println("Main method: " + a) );
	}

}
