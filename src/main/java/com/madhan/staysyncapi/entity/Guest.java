package com.madhan.staysyncapi.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;

    @Column(nullable = false)
    private String guestFirstName;

    @Column(nullable = false)
    private String guestLastName;

    @Column(nullable = false)
    private String guestDateOfBirth;
}
