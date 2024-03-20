package com.agis.AdminService.repository;

import com.agis.AdminService.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
