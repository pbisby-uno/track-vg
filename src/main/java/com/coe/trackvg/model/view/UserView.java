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
public class UserView {

  @JsonProperty("id")
  private int id;

  @JsonProperty("username")
  private String username;

  @JsonProperty("enabled")
  private boolean enabled;

}
