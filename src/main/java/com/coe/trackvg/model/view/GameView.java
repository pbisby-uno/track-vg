package com.coe.trackvg.model.view;

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
  private TitleView title;

  @JsonProperty
  private PlatformView platform;

  @JsonProperty
  private GenreView genre;

}
