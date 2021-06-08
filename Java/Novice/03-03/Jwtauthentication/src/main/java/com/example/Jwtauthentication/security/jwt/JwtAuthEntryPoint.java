package com.example.Jwtauthentication.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);

    @SuppressWarnings("PlaceholderCountMatchesArgumentCount")
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, org.springframework.security.core.AuthenticationException e) {

        logger.error("Unauthorized error. Message - {}", e);
        try {
            assert false;
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");
        } catch (java.io.IOException exception) {
            exception.printStackTrace();
        }
    }

}
