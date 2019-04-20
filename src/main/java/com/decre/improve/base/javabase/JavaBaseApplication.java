package com.decre.improve.base.javabase;

import com.decre.improve.base.javabase.mongo.dao.BaikeDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JavaBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBaseApplication.class, args);
		BaikeDao baikeDao = new BaikeDao();
		baikeDao.testInsert();
	}

}

