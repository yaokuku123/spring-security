package com.yqj.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqj.config.RsaKeyProperties;
import com.yqj.domain.SysRole;
import com.yqj.domain.SysUser;
import com.yqj.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: TokenLoginFilter
 * Author: yaoqijun
 * Date: 2021/2/25 9:55
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private RsaKeyProperties prop;

    public TokenLoginFilter(AuthenticationManager authenticationManager, RsaKeyProperties prop) {
        this.authenticationManager = authenticationManager;
        this.prop = prop;
    }

    //接收并解析用户凭证，出現错误时，返回json数据前端
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            //将json格式请求体转成JavaBean对象
            SysUser user = new ObjectMapper().readValue(request.getInputStream(), SysUser.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
            try {
                //如果认证失败，提供自定义json格式异常
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                Map<String,Object> map = new HashMap<>();
                map.put("code",HttpServletResponse.SC_UNAUTHORIZED);
                map.put("msg","账号或密码错误");
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
            throw new RuntimeException(e);
        }
    }

    //用户登录成功后，生成token,并且返回json数据给前端
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //得到当前认证的用户对象
        SysUser user = new SysUser();
        user.setUsername(authResult.getName());
        user.setRoles((List<SysRole>) authResult.getAuthorities());
        //json web token构建
        String token = JwtUtils.generateTokenExpireInMinutes(user, prop.getPrivateKey(), 24 * 60);
        //返回token
        response.addHeader("Authorization","Bearer "+token);
        //登录成功后，返回json格式进行提示
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        Map<String,Object> map = new HashMap<>();
        map.put("code",HttpServletResponse.SC_OK);
        map.put("msg","登录成功");
        out.write(new ObjectMapper().writeValueAsString(map));
        out.flush();
        out.close();
    }
}
