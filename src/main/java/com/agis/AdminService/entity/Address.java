package com.agis.AdminService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;

}
