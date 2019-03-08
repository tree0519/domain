package com.liu.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScans;

@SpringCloudApplication
@EnableZuulProxy
@EnableHystrix
@EnableAutoConfiguration
public class DomainGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(DomainGatewayApplication.class, args);
	}

}
