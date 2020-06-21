package com.lab1.Repositories;

import com.lab1.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Short> {
    @Query("select u from User u where u.email =:email and u.password =:password")
    public User getUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);
    @Query("select u from User u where u.email =:email")
    public User getUserByEmail(@Param("email") String email);
    @Transactional
    @Modifying
    @Query("update User u set u.code=:code where u.email=:email")
    public void setCode(@Param("code") String code,@Param("email") String email);
    @Query("select u from User u where u.email =:email and u.code=:code")
    public User getUserByEmailAAndCode(@Param("email") String email ,@Param("code") String code);
    @Transactional
    @Modifying
    @Query("update User u set u.password=:password where u.email=:email")
    void updatePass(@Param("email")String email, @Param("password")String password);
}
