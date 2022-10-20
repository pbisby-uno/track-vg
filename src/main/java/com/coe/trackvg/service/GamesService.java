package com.coe.trackvg.service;

import com.coe.trackvg.mapper.Mapper;
import com.coe.trackvg.model.dto.GameDto;
import com.coe.trackvg.model.entity.Game;
import com.coe.trackvg.repository.GamesRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GamesService {

  private final GamesRepository gamesRepository;
  private final Mapper mapper;

  public List<GameDto> getGames() {
    final List<Game> gameList = gamesRepository.findAll();

    return mapper.map(gameList, GameDto.class);
  }

  public GameDto getGame(final int gameId) {
    final Optional<Game> optionalGame = gamesRepository.findById(gameId);
    final Game game = optionalGame.orElseThrow(RuntimeException::new);

    return mapper.map(game, GameDto.class);
  }
}
