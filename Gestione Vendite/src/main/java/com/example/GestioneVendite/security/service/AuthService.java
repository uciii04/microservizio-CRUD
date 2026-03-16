package com.example.GestioneVendite.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.GestioneVendite.security.dto.AuthResponse;
import com.example.GestioneVendite.security.dto.LoginRequest;
import com.example.GestioneVendite.security.dto.RegisterRequest;
import com.example.GestioneVendite.security.model.Role;
import com.example.GestioneVendite.security.model.User;
import com.example.GestioneVendite.security.repository.UserRepository;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository utenteRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username già esistente");
        }

        Role role = Role.ROLE_CLIENTE;

        if ("ADMIN".equalsIgnoreCase(request.getRole())) {
            role = Role.ROLE_ADMIN;
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        userRepository.save(user);

        return new AuthResponse("Registrazione completata");
    }

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        return new AuthResponse("Login effettuato con successo");
    }
}
