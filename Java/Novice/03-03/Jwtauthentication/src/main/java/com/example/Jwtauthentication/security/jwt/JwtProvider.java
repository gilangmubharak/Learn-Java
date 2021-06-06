package com.example.Jwtauthentication.security.jwt;

import com.example.Jwtauthentication.service.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import javax.sql.RowSet;
import java.util.Date;

public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("{.app.jwtSecret}")
    private String jwtSecret;

    @Value("{.app.jwtExpiration}")
    private String jwtExpiration;
    private Date expiration;

    public JwtBuilder generateJwtToken(Authentication authentication) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        RowSet userPrincipal = null;
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()));
                setIssuedAt(new Date());
                setExpiration(new Date((new Date()).getTime() + jwtExpiration));
                signWith(SignatureAlgorithm.HS512, jwtSecret);
                compact();
    }

    

    private void compact() {
    }

    private void signWith(SignatureAlgorithm hs512, String jwtSecret) {
    }

    private void setIssuedAt(Date date) {


    }

    public String getUserNameFromJwtToken(String Token) {
        String token = null;
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

public boolean validateJwtToken(String authtoken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authtoken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid Jwt signature -> Message: {}", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message{}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message{}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Massage: {}", e);
        }

        return false;


        }


    public Object validateJwtToken(Object jwt) {
        return null;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Date getExpiration() {
        return expiration;
    }
}
