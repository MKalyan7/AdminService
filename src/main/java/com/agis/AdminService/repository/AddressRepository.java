package com.agis.AdminService.repository;

import com.agis.AdminService.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
