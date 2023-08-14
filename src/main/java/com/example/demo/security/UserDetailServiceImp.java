package com.example.demo.security;

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Usuarios usuario= usuariosRepository.findOneByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("No Found"));
        return new UserDetailsImp(usuario);
    }
}
