package com.example.Jwtauthentication.message.response;

import io.jsonwebtoken.JwtBuilder;

public class JwtResponse {
    private JwtBuilder token;
    private String type = "Bearer";
    private JwtBuilder accsessToken;
    private String tokenType;

    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }

    public String getGetAccessToken() {
        return getGetAccessToken();
    }

    public void setAccesToken() {
        this.token = accsessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType() {
        this.type = tokenType;
    }


}
