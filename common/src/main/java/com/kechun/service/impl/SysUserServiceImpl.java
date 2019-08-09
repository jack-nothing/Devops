package com.kechun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kechun.dao.SysUserMapper;
import com.kechun.entity.SysUser;
import com.kechun.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService{

}