package com.Proyecto.ONU.Repository.Models;

import lombok.Data;

@Data
public class JWTRequest {
    
    private String username;
    private String password;

}