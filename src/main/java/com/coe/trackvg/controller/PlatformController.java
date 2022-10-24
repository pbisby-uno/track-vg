package com.coe.trackvg.controller;

import com.coe.trackvg.mapper.Mapper;
import com.coe.trackvg.model.dto.CreatePlatformDto;
import com.coe.trackvg.model.dto.PlatformDto;
import com.coe.trackvg.model.view.CreatePlatformView;
import com.coe.trackvg.model.view.PlatformView;
import com.coe.trackvg.service.PlatformService;
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

  private final PlatformService platformService;
  private final Mapper mapper;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PlatformView>> getPlatforms() {

    final List<PlatformDto> platformDtoList = platformService.getPlatforms();

    return platformDtoList.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(mapper.map(platformDtoList, PlatformView.class));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> createPlatform(@Valid @RequestBody CreatePlatformView createPlatformView) {

    platformService.createPlatform(mapper.map(createPlatformView, CreatePlatformDto.class));

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{platformId}")
  public ResponseEntity<HttpStatus> deletePlatform(@PathVariable final int platformId) {

    platformService.deletePlatform(platformId);

    return ResponseEntity.noContent().build();
  }

}
