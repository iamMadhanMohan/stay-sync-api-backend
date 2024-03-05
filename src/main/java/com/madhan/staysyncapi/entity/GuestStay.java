package com.madhan.staysyncapi.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class GuestStay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestStayId;

    // @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @Column(nullable = false)
    private String guestCheckinDate;

    @Column(nullable = false)
    private String guestCheckoutDate;

    @Column(nullable = false)
    private String guestRoomType;

    @Column(nullable = false)
    private Integer guestRoomNumber;

    @Column(nullable = false)
    private Double guestAmountPaid;

    @Column(nullable = false)
    private Double guestAmountBalance;

    @Column(nullable = false)
    private Double guestTotalAmount;

    @Column(nullable = false)
    private Boolean isCheckout;
}
