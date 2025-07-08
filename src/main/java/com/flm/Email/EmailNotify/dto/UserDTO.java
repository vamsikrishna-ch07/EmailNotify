package com.flm.Email.EmailNotify.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {


    private Long id;
    private String userName;
    private String description;

    private List<PostDTO> posts;
}
