package com.vmw.repository;

import com.vmw.entity.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CabRepository extends JpaRepository<Cab,Integer> {
    List<Cab> findByAvailableAndCabType(final boolean avilable,final String cabType);
}
