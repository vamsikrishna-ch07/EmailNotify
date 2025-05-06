package com.flm.Email.EmailNotify.dto;

import com.flm.Email.EmailNotify.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProfileDTO {
    private  Long id;
    private String fullName;
    private UserDTO user;
}
