package com.madhan.staysyncapi.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CheckInRequestDto {
    private String guestFirstName;
    private String guestLastName;
    private String guestDateOfBirth;
    private String guestCheckinDate;
    private String guestCheckoutDate;
    private String guestRoomType;
    private Integer guestRoomNumber;
    private Double guestAmountPaid;
    private Double guestAmountBalance;
    private Double guestTotalAmount;
}
