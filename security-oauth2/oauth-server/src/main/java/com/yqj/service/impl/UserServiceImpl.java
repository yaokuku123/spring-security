package com.yqj.service.impl;

import com.yqj.domain.SysUser;
import com.yqj.mapper.UserMapper;
import com.yqj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: UserServiceImpl
 * Author: yaoqijun
 * Date: 2021/2/24 10:19
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userMapper.findByName(username);
        return user;
    }
}
