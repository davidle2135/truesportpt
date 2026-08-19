package com.truesportpt.backend.repository;

import com.truesportpt.backend.entity.*;
import org.springframework.data.jpa.repository.*;


//////////////////////////////////////////////////////////////////////////
// 
// The repository layer allows for persistent communication with the 
// database. 
//
//////////////////////////////////////////////////////////////////////////
public interface UserRepository extends JpaRepository<User, Long> {
}
