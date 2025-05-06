package com.flm.Email.EmailNotify.service;

import com.flm.Email.EmailNotify.builder.ProfileBuilder;
import com.flm.Email.EmailNotify.dao.ProfileRepository;
import com.flm.Email.EmailNotify.dto.ProfileDTO;
import com.flm.Email.EmailNotify.exception.ProfileException;
import com.flm.Email.EmailNotify.model.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);
    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository=profileRepository;//or for test purpose use this is the best otherwise simply use autowired or requiredargsconstructor
    }

    public ProfileDTO saveProfile(ProfileDTO profileDTO) {
        try {
            Profile profile = ProfileBuilder.profileFromProfileDTO(profileDTO);

            Profile saveProfile = profileRepository.save(profile);
            logger.info("successfully saved data" + saveProfile.getId());
            return ProfileBuilder.profileDTOFromProfile(saveProfile);
        }catch (DataAccessException e){
            logger.warn("something is error while save data :"+e.getMessage());
            throw new ProfileException("save profile:" + e.getMessage());
       }catch (Exception ex){
           logger.error("something is error while save data:"+ex.getMessage());
          throw new ProfileException("save profile:" + ex.getMessage());
       }

    }


    public List<ProfileDTO> getProfile(){
        List<Profile> profiles= profileRepository.findAll();
       return profiles.stream()
               //.map(profile->ProfileBuilder.profileDTOFromProfile(profile))-------use this or simply go below
               .map(ProfileBuilder::profileDTOFromProfile)
               .collect(Collectors.toList());
    }

    public List<ProfileDTO> getProfileSortedByName(){
        List<Profile> profiles= profileRepository.getProfilesSortedByName();
        return profiles.stream()
                //.map(profile->ProfileBuilder.profileDTOFromProfile(profile))-------use this or simply go below
                .map(ProfileBuilder::profileDTOFromProfile)
                .collect(Collectors.toList());
    }


    public void deleteProfile(Long id){
        profileRepository.deleteProfileById(id);
    }

    public ProfileDTO updateProfile(Long id , ProfileDTO name ){
        Profile profile=profileRepository.findById(id)
                .orElseThrow(()->{
                    logger.info("id not found {}:" +id);
                    return new ProfileException("this is a exception because no data here"+ id);
                });
        profile.setFullName(name.getFullName());
        Profile updateProfile=profileRepository.save(profile);
return ProfileBuilder.profileDTOFromProfile(profile);
    }
}
