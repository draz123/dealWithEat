package com.yummy.security;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000 * 3; // 30 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/user/create";
    public static final String MOCK_DATA = "/mock/users";
    public static final String WEB_SOCKET = "/restaurant-panel/**";

}