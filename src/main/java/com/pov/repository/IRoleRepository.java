package com.pov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pov.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

}
