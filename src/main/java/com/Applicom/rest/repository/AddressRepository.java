package com.Applicom.rest.repository;

import com.Applicom.rest.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address>  findByAddrContaining(String addr);
    @Modifying
    @Query(value = "delete from ADDRESS_TABLE at where at.addr = :address")
    void deleteDuplicateAddress(@Param("address") String address);
}
