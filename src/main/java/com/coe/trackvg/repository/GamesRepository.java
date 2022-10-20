package com.coe.trackvg.repository;

import com.coe.trackvg.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Game, Integer> {

}