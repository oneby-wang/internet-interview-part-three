package com.oneby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName BootRedis01Application
 * @Description TODO
 * @Author Oneby
 * @Date 2021/2/2 18:54
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootRedis02Application {
    public static void main(String[] args) {
        SpringApplication.run(BootRedis02Application.class);
    }
}