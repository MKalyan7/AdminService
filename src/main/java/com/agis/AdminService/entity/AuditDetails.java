package com.agis.AdminService.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public  class AuditDetails {

    private String createdBy;
    private String updatedBy;
    private Instant createdDate;
    private Instant updatedDate;
}
