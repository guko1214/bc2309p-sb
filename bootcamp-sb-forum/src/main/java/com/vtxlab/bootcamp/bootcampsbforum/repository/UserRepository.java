package com.vtxlab.bootcamp.bootcampsbforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

@Repository // -> Bean, similar to @Controller /@Service
//public class UserRepository extends JpaRepository<User, Long> {
 public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Boot (Hibernate - implementation class for JPA Interface)
    // Hiberate usage: According to the driver (yml),
    // 1. it can generate corresponding SQ: syntax
    // 2. this class also implementing interface UserRepository -> bean

}
