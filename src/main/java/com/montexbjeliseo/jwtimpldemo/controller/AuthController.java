package com.montexbjeliseo.jwtimpldemo.controller;

import com.montexbjeliseo.jwtimpldemo.dto.LoginUserDTO;
import com.montexbjeliseo.jwtimpldemo.dto.RegisterUserDTO;
import com.montexbjeliseo.jwtimpldemo.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author montexbjeliseo
 */

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private IAuthService authService;
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDTO dto){
        try  {
            return new ResponseEntity<>(authService.register(dto), HttpStatus.OK);
        } catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO dto){
        return new ResponseEntity<>(authService.login(dto), HttpStatus.OK);
    }
}
