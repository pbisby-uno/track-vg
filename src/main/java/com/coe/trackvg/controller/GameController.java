package com.coe.trackvg.controller;

import com.coe.trackvg.mapper.Mapper;
import com.coe.trackvg.model.dto.GameDto;
import com.coe.trackvg.model.view.CreateUserGameView;
import com.coe.trackvg.model.view.GameView;
import com.coe.trackvg.model.view.UserGameView;
import com.coe.trackvg.service.GamesService;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
@Validated
@Slf4j
public class GameController {

  private final GamesService gamesService;
  private final Mapper mapper;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<GameView>> getGames() {

    final List<GameDto> gameDtoList = gamesService.getGames();

    return ResponseEntity.ok(mapper.map(gameDtoList, GameView.class));
  }

  @GetMapping(value = "/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GameView> getGame(@PathVariable final int gameId) {

    final GameDto gameDto = gamesService.getGame(gameId);

    return ResponseEntity.ok(mapper.map(gameDto, GameView.class));
  }

  @GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<UserGameView>> getUserGames(@PathVariable final int userId) {

    return ResponseEntity.ok(Collections.emptyList());
  }

  @PostMapping(value = "/users/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> createUserGame(
      @PathVariable final int userId,
      @Valid @RequestBody final CreateUserGameView createUserGame) {

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
