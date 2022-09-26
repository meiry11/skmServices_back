package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role,Integer> {
}
