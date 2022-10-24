package com.coe.trackvg.controller;

import com.coe.trackvg.mapper.Mapper;
import com.coe.trackvg.model.dto.CreateGenreDto;
import com.coe.trackvg.model.dto.GenreDto;
import com.coe.trackvg.model.view.CreateGenreView;
import com.coe.trackvg.model.view.GenreView;
import com.coe.trackvg.service.GenreService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
@Validated
@Slf4j
public class GenreController {

  private final GenreService genreService;
  private final Mapper mapper;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<GenreView>> getGenres() {

    final List<GenreDto> genreDtoList = genreService.getGenres();

    return genreDtoList.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(mapper.map(genreDtoList, GenreView.class));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> createGenre(@Valid @RequestBody CreateGenreView createGenreView) {

    genreService.createGenre(mapper.map(createGenreView, CreateGenreDto.class));

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{genreId}")
  public ResponseEntity<HttpStatus> deleteGenre(@PathVariable final int genreId) {

    genreService.deleteGenre(genreId);

    return ResponseEntity.noContent().build();
  }

}
