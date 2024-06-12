package com.wevel.wevel_server.global.config.service;

import java.util.Map;
public class GoogleUserInfo implements OAuth2UserInfo{

    private Map<String, Object> attributes; // getAttributes

    public GoogleUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }
}