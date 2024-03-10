package com.agis.AdminService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyRequest {

    private Long companyId;
    private String companyName;
    private List<AddressRequest> addresses;
    private Boolean companyStatus;



}
