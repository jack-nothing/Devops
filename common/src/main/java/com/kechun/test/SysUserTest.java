package com.kechun.test;


import com.kechun.CommonApplication;
import com.kechun.entity.SysUser;
import com.kechun.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CommonApplication.class)
public class SysUserTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void test1(){
        SysUser sysUser = sysUserService.selectById(1);
        System.out.println(sysUser);
    }


}