package com.turgayyilmaz.InterProbeHW1.dao;


import com.turgayyilmaz.InterProbeHW1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
