package com.wevel.wevel_server.global.config.service;

import org.springframework.security.oauth2.core.user.OAuth2User;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, OAuth2User oAuth2User) {
        if (registrationId.equalsIgnoreCase("naver")) {
            return new NaverUserInfo(oAuth2User.getAttributes());
        } else if (registrationId.equalsIgnoreCase("google")) {
            return new GoogleUserInfo(oAuth2User.getAttributes());
        } else {
            throw new IllegalArgumentException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}