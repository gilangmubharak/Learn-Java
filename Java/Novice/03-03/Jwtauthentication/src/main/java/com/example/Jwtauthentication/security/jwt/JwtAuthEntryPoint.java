package com.example.Jwtauthentication.security.jwt;

import kotlin.jvm.Throws;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@Component
public abstract class JwtAuthEntryPoint implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);

    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) {

    }

    Throws IOException, ServletException;



        public Error e; {
        logger.error("Unauthorized error. Message - {}", e);
        Response response = null;
        try {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
