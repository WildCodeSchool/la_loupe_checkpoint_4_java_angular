package com.wildcodeschool.checkpoint.wcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.checkpoint.wcs.entity.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {

}
