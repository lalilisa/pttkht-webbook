package com.n10.webbook.jwt;


public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;

    public JwtResponse(String accessToken, Long id, String username) {
        this.token = accessToken;
        this.username = username;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
