package com.oneby.aop;

import org.springframework.stereotype.Service;

/**
 * @ClassName CalcServiceImpl
 * @Description TODO
 * @Author Oneby
 * @Date 2021/1/22 11:15
 * @Version 1.0
 */
@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public int div(int x, int y) {
        int result = x / y;
        System.out.println("=========>CalcServiceImpl被调用了,我们的计算结果：" + result);
        return result;
    }
}

