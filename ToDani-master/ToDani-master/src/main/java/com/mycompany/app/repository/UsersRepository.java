package com.mycompany.app.repository;




import com.mycompany.app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface UsersRepository extends JpaRepository<Users, UUID> {
    @Query(value="SELECT * FROM users a JOIN roles b ON a.role_id = b.role_id WHERE a.user_name = ?1", nativeQuery = true)
    Users findByUserName(String UserName);
}
