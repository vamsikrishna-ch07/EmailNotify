package com.flm.Email.EmailNotify;

import com.flm.Email.EmailNotify.dao.ProfileRepository;
import com.flm.Email.EmailNotify.dto.PostDTO;
import com.flm.Email.EmailNotify.dto.ProfileDTO;
import com.flm.Email.EmailNotify.dto.UserDTO;
import com.flm.Email.EmailNotify.model.Post;
import com.flm.Email.EmailNotify.model.Profile;
import com.flm.Email.EmailNotify.model.User;

import com.flm.Email.EmailNotify.service.ProfileServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceImplTest {

    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private ProfileServiceImpl profileService;

    @Test
    void testSaveProfile_Success() {


        ProfileDTO profileDTO = ProfileDTO.builder()
                .fullName("Test User")
                .user(UserDTO.builder()
                        .userName("TestUser")
                        .posts(Collections.singletonList(
                                PostDTO.builder().content("Test post").build()))
                        .build())
                .build();

        Profile profile = Profile.builder()
                .fullName("Test User")
                .user(User.builder()
                        .userName("TestUser")//below if we use more than single list we can go  with list.of,arras.aslistof like that otherwise simply use collection.singltone(it is a static method from collections
                        .posts(List.of(
                                Post.builder().content("Test post").build()
                                //Post.builder().content("Post 2").build()
                        ))
                        .build())
                .build();


        when(profileRepository.save(any(Profile.class))).thenReturn(profile);


        ProfileDTO result = profileService.saveProfile(profileDTO);


        assertNotNull(result);
        assertEquals("Test User", result.getFullName());
        assertEquals("TestUser", result.getUser().getUserName());
        assertEquals("Test post", result.getUser().getPosts().get(0).getContent());

        verify(profileRepository, times(1)).save(any(Profile.class));
    }


}
