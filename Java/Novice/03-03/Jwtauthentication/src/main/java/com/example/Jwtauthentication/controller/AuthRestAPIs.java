package com.example.Jwtauthentication.controller;

import com.example.Jwtauthentication.message.request.LoginForm;
import com.example.Jwtauthentication.message.request.SignUpForm;
import com.example.Jwtauthentication.message.response.JwtResponse;
import com.example.Jwtauthentication.model.Role;
import com.example.Jwtauthentication.model.RoleName;
import com.example.Jwtauthentication.model.User;
import com.example.Jwtauthentication.repository.RoleRepository;
import com.example.Jwtauthentication.repository.UserRepository;
import com.example.Jwtauthentication.security.jwt.JwtProvider;
import io.jsonwebtoken.JwtBuilder;
import jdk.internal.dynalink.support.NameCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtProvider jwtProvider;
    private NameCodec encoder;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Validated @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Validated @RequestBody SignUpForm signUpRequest) {
        if (userRepository.existingByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("Fail -> Email is already in taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existingByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Fail -> is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        Set strRoles = signUpRequest.getRole();
        Set roles = new HashSet<>();

        strRoles.forEach(role ->{
            if ("admin".equals(role)) {
                Role adminRole = null;
                try {
                    adminRole = (Role) roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail -> Cause: User Role not find."));
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                roles.add(adminRole);
            } else if ("pm".equals(role)) {
                Role pmRole = null;
                try {
                    pmRole = (Role) roleRepository.findByName(RoleName.ROLE_PM)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                roles.add(pmRole);
            } else {
                Role userRole = null;
                try {
                    userRole = (Role) roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");

    }
}
