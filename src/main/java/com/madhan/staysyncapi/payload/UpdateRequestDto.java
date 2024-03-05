package com.madhan.staysyncapi.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequestDto {

    private Long guestId;
    private String guestFirstName;
    private String guestLastName;
    private String guestDateOfBirth;
    private Long guestStayId;
    private String guestCheckinDate;
    private String guestCheckoutDate;
    private String guestRoomType;
    private Integer guestRoomNumber;
    private Double guestAmountPaid;
    private Double guestAmountBalance;
    private Double guestTotalAmount;
}
