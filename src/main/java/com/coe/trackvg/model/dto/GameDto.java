package com.coe.trackvg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameDto {

  private int id;
  private TitleDto title;
  private PlatformDto platform;
  private GenreDto genre;

}
