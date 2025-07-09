package com.flm.Email.EmailNotify.builder;

import com.flm.Email.EmailNotify.dto.PostDTO;
import com.flm.Email.EmailNotify.dto.ProfileDTO;
import com.flm.Email.EmailNotify.dto.UserDTO;
import com.flm.Email.EmailNotify.model.Post;
import com.flm.Email.EmailNotify.model.Profile;
import com.flm.Email.EmailNotify.model.User;

import java.util.stream.Collectors;

public class ProfileBuilder {

    public static Profile profileFromProfileDTO(ProfileDTO dto) {

        return Profile.builder()
                .id(dto.getId())
                .fullName(dto.getFullName())
                .user(User.builder()
                        .id(dto.getUser().getId())
                        .userName(dto.getUser().getUserName())
                        .description(dto.getUser().getDescription())
                        .posts(dto.getUser().getPosts().stream()
                                .map(post -> Post.builder()
                                        .id(post.getId())
                                        .content(post.getContent())
                                        .build())
                                .collect(Collectors.toList()))

                        .build())
                .build();


    }


    public static ProfileDTO profileDTOFromProfile(Profile profile) {
        return ProfileDTO.builder()
                .id(profile.getId())
                .fullName(profile.getFullName())
                .user(UserDTO.builder()
                        .id(profile.getUser().getId())
                        .userName(profile.getUser().getUserName())
                        .description(profile.getUser().getDescription())
                        .posts(profile.getUser().getPosts().stream()
                                .map(post -> PostDTO.builder()
                                        .id(post.getId())
                                        .content(post.getContent())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .build();
    }
}


