package com.northlas.supportportal.constant;

public class SecurityConstant {
    public static final String PROXY_HOST = "kpproxygsit";
    public static final int PROXY_PORT = 8080;
    public static final long EXPIRATION_TIME = 432_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String NORTHLAS_LLC = "NorthLas, LLC";
    public static final String NORTHLAS_ADMINISTRATION = "User Management Portal";
    public static final String AUTHORITIES = "authorities";
    public static final String FORBIDDEN_MESSAGE = "Log in required to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "Permission required to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = { "/user/login", "/user/register", "/user/image/**", "/login**"};
}
