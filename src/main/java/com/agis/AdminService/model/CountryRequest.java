package com.agis.AdminService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryRequest {
    private String countryCode;
    private String countryName;
    private List<StateRequest> states;

}
