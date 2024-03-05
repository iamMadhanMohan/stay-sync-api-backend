package com.madhan.staysyncapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
    @Id
    private Integer roomNumber;

    @Column(nullable = false)
    private String roomType;

    @Column(nullable = false)
    private Boolean isOccupied;
}
