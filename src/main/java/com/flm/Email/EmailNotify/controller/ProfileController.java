package com.flm.Email.EmailNotify.controller;

import com.flm.Email.EmailNotify.dto.ProfileDTO;
import com.flm.Email.EmailNotify.service.ProfileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProfileController {

    private final ProfileServiceImpl profileService;

    @PostMapping("/save")
    public ResponseEntity<ProfileDTO> saveUser(@RequestBody ProfileDTO profileDTO) {
        ProfileDTO profile = profileService.saveProfile(profileDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(profile);

    }

    @PutMapping("/UpdateFullName")
    public ResponseEntity<ProfileDTO> UpdateProfile(@RequestParam Long id, @RequestBody ProfileDTO DTO) {
        ProfileDTO updateProfile = profileService.updateProfile(id, DTO);
        return ResponseEntity.ok(updateProfile);

    }

    @GetMapping("/get")
    public ResponseEntity<List<ProfileDTO>> getData() {
        List<ProfileDTO> allDataList = profileService.getProfile();
        return ResponseEntity.ok(allDataList);
    }

    @GetMapping("/sortedData")
    public ResponseEntity<List<ProfileDTO>> getSortedData() {
        List<ProfileDTO> allDataList = profileService.getProfileSortedByName();
        return ResponseEntity.ok(allDataList);
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.ok("Profile and related data deleted successfully.");
    }


}