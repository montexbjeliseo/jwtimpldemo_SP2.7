package com.montexbjeliseo.jwtimpldemo.dto;

/**
 *
 * @author montexbjeliseo
 */
public class TokenDTO {

    private static final long serialVersionUID = 1L;

    private final String jwtToken;

    public TokenDTO(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }
}
