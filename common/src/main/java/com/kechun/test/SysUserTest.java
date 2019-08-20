package com.kechun.test;


import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kechun.CommonApplication;
import com.kechun.entity.SysUser;
import com.kechun.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CommonApplication.class)
public class SysUserTest {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    com.alibaba.druid.pool.DruidDataSource druidDataSource;
    @Test
    public void test() {
        System.out.println(druidDataSource);
        //分页
        IPage<SysUser> page = new Page<>(1, 20);
        QueryWrapper<SysUser> wapper = new QueryWrapper<>();
        page = sysUserService.selectPage(page, wapper);
        System.out.println(page.getRecords());
    }


    @Test
    public void test1(){
        SysUser sysUser = sysUserService.selectById(1);

        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.select("select count(1) from t_sys_user");
//        qw.setEntity()
//        qw.isNotNull()
        int i = sysUserService.selectCount(qw);
        System.out.println(i);
        System.out.println(sysUser);
    }


    @Test
    public void test2(){
        List<SysUser> list = sysUserService.selectList(null);
        System.out.println(list);
    }
}