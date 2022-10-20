package com.coe.trackvg.controller;

import com.coe.trackvg.model.view.CreatePlatformView;
import com.coe.trackvg.model.view.PlatformView;
import java.util.Collections;
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
@RequestMapping("/platforms")
@RequiredArgsConstructor
@Validated
@Slf4j
public class PlatformController {

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PlatformView>> getPlatforms() {

    return ResponseEntity.ok(Collections.emptyList());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> createPlatform(@Valid @RequestBody CreatePlatformView createPlatformView) {

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{platformId}")
  public ResponseEntity<HttpStatus> deletePlatform(@PathVariable final int platformId) {

    return ResponseEntity.noContent().build();
  }

}
