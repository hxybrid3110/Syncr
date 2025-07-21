package com.syncr.Syncr.Repo;

import com.syncr.Syncr.Models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<users,Integer> {

    public users findByUsername(String username);


}