package com.coe.trackvg.model.view;

import com.coe.trackvg.model.dto.GenreDto;
import com.coe.trackvg.model.dto.PlatformDto;
import com.coe.trackvg.model.dto.TitleDto;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class GameView {

  @JsonProperty
  private int id;

  @JsonProperty
  private TitleDto title;

  @JsonProperty
  private PlatformDto platform;

  @JsonProperty
  private GenreDto genre;

}
