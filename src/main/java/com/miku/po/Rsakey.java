package com.miku.po;

import org.springframework.stereotype.Component;

@Component
public class Rsakey {
    private Integer id;

    private String publickey;

    private String privatekey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey == null ? null : publickey.trim();
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey == null ? null : privatekey.trim();
    }
}