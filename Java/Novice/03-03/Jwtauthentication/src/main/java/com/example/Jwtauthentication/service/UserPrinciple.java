package com.example.Jwtauthentication.service;

import com.example.Jwtauthentication.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class UserPrinciple implements UserDetails {
    private static final long serialversionUID = 1L;
    public static String getUsername;

    private Long id;

    private String name;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Collection authorities;

    public UserPrinciple(Long id, String name, String username, String email, String password, Collection authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;

    }

    public static UserPrinciple build(User user) {
        List<String> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name()).getAuthority()).collect(Collectors.toList());

        final UserPrinciple userPrinciple = new UserPrinciple(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities
        ) {

            public Long getId() {
                return getId();
            }

            public String getNAme() {
                return getNAme();
            }

            public String getEmail() {
                return getEmail();
            }

            @Override
            public String getUsername() {
                return getUsername();
            }

            @Override
            public String getPassword() {
                return getPassword();
            }

            @Override
            public Collection getAuthorities() {
                return authorities;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                UserPrinciple user = (UserPrinciple) o;
                return Objects.equals(getId(), user.id);
            }
        };
        return userPrinciple;
    }
}