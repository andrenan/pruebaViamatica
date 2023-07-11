package com.example.demo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegisterSessionAuthenticationStrategy implements SessionAuthenticationStrategy{
    private final SessionRegistry sessionRegistry = new SessionRegistryImpl();

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request,
                                 HttpServletResponse response) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // Almacena el usuario autenticado en la sesión
        sessionRegistry.registerNewSession(request.getSession().getId(), userDetails);
    }
}
