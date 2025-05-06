package com.flm.Email.EmailNotify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    private String fullName;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="user_id")
    private User user;

}
