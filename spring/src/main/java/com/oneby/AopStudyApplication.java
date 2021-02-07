package com.oneby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName AopStudyApplication
 * @Description TODO
 * @Author Oneby
 * @Date 2021/1/22 11:53
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AopStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopStudyApplication.class, args);
    }
}
