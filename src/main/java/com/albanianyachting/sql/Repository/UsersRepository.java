package com.albanianyachting.sql.Repository;

import com.albanianyachting.sql.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT u FROM Users u WHERE u.id = :id")
    Users findOne(@Param("id") Long id);

    @Query(value = "SELECT u FROM Users u WHERE u.role = :role")
    List<Users> findUsersByRole(@Param("role") Long role);
}
