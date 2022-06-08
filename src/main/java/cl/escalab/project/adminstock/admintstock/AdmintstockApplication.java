package cl.escalab.project.adminstock.admintstock;

import cl.escalab.project.adminstock.admintstock.datas.InsertDataDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@ComponentScan({ "cl.escalab.project.adminstock.admintstock.security", "cl.escalab.project.adminstock.admintstock.controllers", "cl.escalab.project.adminstock.admintstock.datas",
		"cl.escalab.project.adminstock.admintstock.services" }) // to scan repository files
@EntityScan("cl.escalab.project.adminstock.admintstock.entities")
@EnableJpaRepositories("cl.escalab.project.adminstock.admintstock.repositories")

public class AdmintstockApplication implements CommandLineRunner {

	@Autowired
	InsertDataDB dataDB;

	public static void main(String[] args) {
		SpringApplication.run(AdmintstockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataDB.populate();

	}


}
