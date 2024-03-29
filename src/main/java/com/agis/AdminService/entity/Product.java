package com.agis.AdminService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends AuditDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String productName;
    private String productCode;
    private Boolean productStatus;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<Country> countries;
}
