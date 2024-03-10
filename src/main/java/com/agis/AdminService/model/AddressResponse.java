package com.agis.AdminService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {
    private Long addressId;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String township;
    private String county;
    private String state;
    private String zipcode;
    private boolean addressStatus;
    private boolean addressValidated;
}
