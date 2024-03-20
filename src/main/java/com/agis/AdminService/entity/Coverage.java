package com.agis.AdminService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "coverage")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coverage extends AuditDetails{

    @Id
    private long coverageId;

    private String coverageCode;

    private String coverageName;

    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDate effectiveDate;

    private LocalDate endDate;

}
