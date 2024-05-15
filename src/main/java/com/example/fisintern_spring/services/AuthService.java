package com.example.fisintern_spring.services;

import com.example.fisintern_spring.dtos.ReqRes;
import com.example.fisintern_spring.entities.User;
import com.example.fisintern_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    public ReqRes signup(ReqRes registrationRequest) {
        ReqRes response = new ReqRes();
        try {
            User user = new User();
            user.setUsername(registrationRequest.getUsername());
            user.setEmail(registrationRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setAccess(registrationRequest.getAccess());
            User result = userRepository.save(user);
            if (result != null && result.getId() != null){
                response.setStatusCode("200");
                response.setMessage("User registered successfully.");
                response.setUser(result);
            }
        } catch (Exception e) {
            response.setStatusCode("500");
            response.setError(e.getMessage());
        }
        return response;
    }

    public ReqRes login(ReqRes loginRequest) {
        ReqRes response = new ReqRes();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword())
            );
            var user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
            System.out.println("User is" + user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode("200");
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("1 min");
            response.setMessage("Login successful.");
        } catch (Exception e) {
            response.setStatusCode("500");
            response.setError(e.getMessage());
        }
        return response;
    }

    public ReqRes refreshToken(ReqRes refreshToken) {
        ReqRes response = new ReqRes();
        String username = jwtUtils.extractUsername(refreshToken.getRefreshToken());
        User user = userRepository.findByUsername(username).orElseThrow();
        if (jwtUtils.isTokenValid(refreshToken.getRefreshToken(), user)) {
            var jwt = jwtUtils.generateToken(user);
            response.setStatusCode("200");
            response.setToken(jwt);
            response.setRefreshToken(refreshToken.getRefreshToken());
            response.setExpirationTime("1 min");
            response.setMessage("Token refreshed successfully.");
        } else {
            response.setStatusCode("500");
            response.setError("Invalid refresh token.");

        }
        return response;
    }
}
