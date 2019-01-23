package com.wildcodeschool.checkpoint.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.checkpoint.main.entites.Chanson;

@Repository
public interface ChansonDAO extends JpaRepository<Chanson, Long>{

}
