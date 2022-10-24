package com.coe.trackvg.controller;

import com.coe.trackvg.mapper.Mapper;
import com.coe.trackvg.model.dto.CreateStatusDto;
import com.coe.trackvg.model.dto.StatusDto;
import com.coe.trackvg.model.view.CreateStatusView;
import com.coe.trackvg.model.view.StatusView;
import com.coe.trackvg.service.StatusService;
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
@RequestMapping("/status")
@RequiredArgsConstructor
@Validated
@Slf4j
public class StatusController {

  private final StatusService statusService;
  private final Mapper mapper;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<StatusView>> getStatuses() {

    final List<StatusDto> statusDtoList = statusService.getStatuses();

    return statusDtoList.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(mapper.map(statusDtoList, StatusView.class));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HttpStatus> createStatus(@Valid @RequestBody CreateStatusView createStatusView) {

    statusService.createStatus(mapper.map(createStatusView, CreateStatusDto.class));

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{statusId}")
  public ResponseEntity<HttpStatus> deleteStatus(@PathVariable final int statusId) {

    statusService.deleteStatus(statusId);

    return ResponseEntity.noContent().build();
  }

}
