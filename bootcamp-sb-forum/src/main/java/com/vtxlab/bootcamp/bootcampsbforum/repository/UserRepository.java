package com.vtxlab.bootcamp.bootcampsbforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;
import java.util.List;


@Repository // -> Bean, similar to @Controller /@Service
//public class UserRepository extends JpaRepository<User, Long> {
 public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Boot (Hibernate - implementation class for JPA Interface)
    // Hiberate usage: According to the driver (yml),
    // 1. it can generate corresponding SQ: syntax
    // 2. this class also implementing interface UserRepository -> bean

    // Approach 1:
    // Query Methods: java method -> JPQL
    // Hibernate: select u from User u where email = ?
    List<User> findByEmail(String email);

    //"Sincere@april.biz"

    // in IT industry, data usually use Java stream, instead of below methods

    // but should know how to use below methods

    // 1
    // Hibernate: select u from u.Users where u.email = ? and u.phone = ? order by u.email desc
    List<User> findByEmailAndPhoneOrderByEmailDesc(String email, String phone);

    // Hibernate: select u from u.Users where u.email = ? or u.phone = ?
    List<User> findByEmailOrPhone(String email, String phone);

    // Approach 2:
    // JPQL: hand-write JPQL
    // Method name is not important in JPQL
    @Query(value = "select u from User u where u.zipcode = :zc")
    List<User> findUsersByZipCode(@Param("zc") String zipcode);

    // 2
    @Query(
        value = "select u from User u where CAST(u.addrLat AS double) > :lat and CAST(u.addrLng AS double) > :lng")
    List<User> findUsersByLatitudeAndLongitude(@Param("lat") String latitude, 
        @Param("lng") String longitude);

    // Approach 3: 
    // Real SQL - Product Specific (PostgreSQL)
    @Query(value = "select * from users e where e.zipcode = :zc",nativeQuery = true)
    List<User> findUsersByZipCode2(@Param("zc") String zipcode);
}
