package com.flm.Email.EmailNotify.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProfileDTO {
    private Long id;
    private String fullName;
    private UserDTO user;
}
