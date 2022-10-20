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
public class CreateUserGameView {

  @JsonProperty("title")
  private String title;

  @JsonProperty("genreId")
  private int genreId;

  @JsonProperty("platformId")
  private int platformId;

  @JsonProperty("statusId")
  private int statusId;

}
