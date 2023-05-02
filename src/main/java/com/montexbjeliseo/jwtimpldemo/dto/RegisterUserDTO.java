package com.montexbjeliseo.jwtimpldemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author montexbjeliseo
 */
@Getter
@Setter
@NoArgsConstructor
public class RegisterUserDTO {
    
    private String username;
    private String password;
}
