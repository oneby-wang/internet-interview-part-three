package com.oneby.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

@SpringBootTest
// @RunWith(SpringRunner.class)  //1.5.9
public class AopTest {
    @Autowired
    private CalcService calcService;

    @Test
    public void testAop4() {
        System.out.println("spring版本：" + SpringVersion.getVersion() + "\t" + "SpringBoot版本：" + SpringBootVersion.getVersion());
        System.out.println();
        calcService.div(10, 0);
    }

    @Test
    public void testAop5() {
        System.out.println("spring版本：" + SpringVersion.getVersion() + "\t" + "SpringBoot版本：" + SpringBootVersion.getVersion());
        System.out.println();
        calcService.div(10, 0);
    }
}