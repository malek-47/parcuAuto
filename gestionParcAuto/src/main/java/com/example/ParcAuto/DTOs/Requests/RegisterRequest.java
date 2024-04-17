package com.example.ParcAuto.DTOs.Requests;

import com.example.ParcAuto.Enum.Fonction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Fonction fonction;
    private String password;

}
