package com.example.crud3.repository;

import com.example.crud3.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository  extends JpaRepository<Phone, Long> {
}
