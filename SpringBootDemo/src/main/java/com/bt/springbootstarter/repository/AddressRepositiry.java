package com.bt.springbootstarter.repository;

import com.bt.springbootstarter.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositiry extends JpaRepository<AddressEntity,Integer> {
}
