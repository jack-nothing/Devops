package com.kechun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kechun.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

public interface SysUserService extends IService<SysUser>{

    List<SysUser> getUserPageList();
}