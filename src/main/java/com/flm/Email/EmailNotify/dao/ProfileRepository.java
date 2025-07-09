package com.flm.Email.EmailNotify.dao;

import com.flm.Email.EmailNotify.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query(value = "SELECT * FROM profile ORDER BY full_name ASC", nativeQuery = true)
    List<Profile> getProfilesSortedByName();
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM post WHERE user_id IN (SELECT id FROM user WHERE user_id = :profileId)", nativeQuery = true)
    void deletePostsByProfileId(@Param("profileId") Long profileId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user WHERE user_id = :profileId", nativeQuery = true)
    void deleteUserByProfileId(@Param("profileId") Long profileId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM profile WHERE id = :profileId", nativeQuery = true)
    void deleteProfileById(@Param("profileId") Long profileId);
}
