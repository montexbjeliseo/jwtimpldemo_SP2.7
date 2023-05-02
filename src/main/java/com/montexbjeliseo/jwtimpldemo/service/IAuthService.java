package com.montexbjeliseo.jwtimpldemo.service;

import com.montexbjeliseo.jwtimpldemo.dto.LoginUserDTO;
import com.montexbjeliseo.jwtimpldemo.dto.RegisterUserDTO;
import com.montexbjeliseo.jwtimpldemo.dto.TokenDTO;

/**
 *
 * @author montexbjeliseo
 */

public interface IAuthService {
    
    public TokenDTO register(RegisterUserDTO dto);
    
    public TokenDTO login(LoginUserDTO dto);
    
}
