package com.montexbjeliseo.jwtimpldemo.service.impl;

import com.montexbjeliseo.jwtimpldemo.dto.LoginUserDTO;
import com.montexbjeliseo.jwtimpldemo.dto.RegisterUserDTO;
import com.montexbjeliseo.jwtimpldemo.dto.TokenDTO;
import com.montexbjeliseo.jwtimpldemo.model.User;
import com.montexbjeliseo.jwtimpldemo.repository.IUserRepository;
import com.montexbjeliseo.jwtimpldemo.service.IAuthService;
import com.montexbjeliseo.jwtimpldemo.util.JwtTokenUtil;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service
@Transactional
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtUtil;

    public TokenDTO register(RegisterUserDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("El nombre de Usuario ya se encuentra definido");
        }

        User newUser = new User();

        newUser.setUsername(dto.getUsername());

        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(newUser);

        return new TokenDTO(jwtUtil.generateToken(savedUser));

    }

    public TokenDTO login(LoginUserDTO dto) {

        if (!userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Usuario no encontrado");
        }

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
            );
            return new TokenDTO(jwtUtil.generateToken((UserDetails) auth.getPrincipal()));
        } catch (BadCredentialsException ex) {
            throw ex;
        }

    }

}
