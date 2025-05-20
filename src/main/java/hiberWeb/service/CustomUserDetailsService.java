package hiberWeb.service;

import hiberWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Ищем пользователя в базе
        User user = userService.findUserByNick(username);
        if (user == null) {
            new UsernameNotFoundException("User not found: " + username);
                }

        // Преобразуем роли в GrantedAuthority
        Set<GrantedAuthority> authorities = user.getRolesList().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet());

        // Создаем объект UserDetails
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getNickName(),
                user.getPassword(),
                authorities
        );
        return userDetails;
    }

}