package com.example.demo.security;

import org.hibernate.annotations.Filter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");
        TokenUtils tokenUtils = new TokenUtils();

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            String token = bearerToken.replace("Bearer ", "");
            System.out.println(token);
            UsernamePasswordAuthenticationToken usernamePA = tokenUtils.getAuthentication(token);

            SecurityContextHolder.getContext().setAuthentication(usernamePA);
        }
        filterChain.doFilter(request, response);
    }
}

