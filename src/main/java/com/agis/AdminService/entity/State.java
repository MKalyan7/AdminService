package com.agis.AdminService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "state")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stateId;
    private String stateCode;
    private String stateName;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


}
