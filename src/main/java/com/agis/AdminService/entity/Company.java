package com.agis.AdminService.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "COMPANY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company extends AuditDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;
    @Column(name = "NAME")
    private String companyName;
    @Column(name = "STATUS")
    private Boolean companyStatus;
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Address> address;

}
