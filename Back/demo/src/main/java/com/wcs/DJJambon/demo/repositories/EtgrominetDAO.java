package com.wcs.DJJambon.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.DJJambon.demo.entities.Etgrominet;


@Repository
public interface EtgrominetDAO extends JpaRepository <Etgrominet, Long> {

}

