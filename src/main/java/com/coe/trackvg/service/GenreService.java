package com.coe.trackvg.service;

import com.coe.trackvg.mapper.Mapper;
import com.coe.trackvg.model.dto.CreateGenreDto;
import com.coe.trackvg.model.dto.GenreDto;
import com.coe.trackvg.model.entity.Genre;
import com.coe.trackvg.repository.GenreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreService {

  private final GenreRepository genreRepository;
  private final Mapper mapper;

  public List<GenreDto> getGenres() {
    final List<Genre> genreList = genreRepository.findAll();

    return mapper.map(genreList, GenreDto.class);
  }

  public void createGenre(final CreateGenreDto createGenreDto) {
    final Genre newGenre = Genre
        .builder()
        .description(createGenreDto.getGenre())
        .build();

    genreRepository.saveAndFlush(newGenre);
  }

  public void deleteGenre(final int genreId) {
    genreRepository.deleteById(genreId);
  }
}
