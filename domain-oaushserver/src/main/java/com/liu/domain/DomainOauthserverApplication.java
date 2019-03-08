package com.liu.domain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringCloudApplication
@EnableFeignClients
@EnableHystrix
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DomainOauthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainOauthserverApplication.class, args);
	}
}
