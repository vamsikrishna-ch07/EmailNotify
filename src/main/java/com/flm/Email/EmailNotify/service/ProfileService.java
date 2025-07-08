package com.flm.Email.EmailNotify.service;

import com.flm.Email.EmailNotify.dto.ProfileDTO;

import java.util.List;

public interface ProfileService {
    public ProfileDTO saveProfile(ProfileDTO profileDTO);

    public List<ProfileDTO> getProfile();

    public List<ProfileDTO> getProfileSortedByName();

    public void deleteProfile(Long id);

    public ProfileDTO updateProfile(Long id, ProfileDTO name);
}
