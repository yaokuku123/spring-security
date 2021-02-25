package com.yqj.config;

import com.yqj.utils.RsaUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: RsaKeyProperties
 * Author: yaoqijun
 * Date: 2021/2/25 9:47
 */
@Data
@ConfigurationProperties("yqj.key")
public class RsaKeyProperties {
    private String privateKeyPath;
    private String publicKeyPath;

    private PrivateKey privateKey;
    private PublicKey publicKey;

    @PostConstruct
    public void loadKey() throws Exception {
        privateKey = RsaUtils.getPrivateKey(privateKeyPath);
        publicKey = RsaUtils.getPublicKey(publicKeyPath);
    }
}
