package com.example.demo;

import com.example.demo.model.RolUsuarios;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.RolUsuariosRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuariosRepository repo;
    @Autowired
    private RolUsuariosRepository repo2;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuarios user= repo.findByUsername(username);
        List<RolUsuarios> roles = repo2.getAllByUsuarios(user.getId());
        List<GrantedAuthority> authorities = roles.
                stream()
                .map(rol ->new SimpleGrantedAuthority(rol.getRol().getRolName()))
                .peek(authority -> authority.getAuthority())
                .collect(Collectors.toList());
        return new User(user.getUserName(), user.getPassword(),true,true,true,true,authorities);
    }
}
