package com.coe.trackvg.service;

import com.coe.trackvg.mapper.Mapper;
import com.coe.trackvg.model.dto.CreateStatusDto;
import com.coe.trackvg.model.dto.StatusDto;
import com.coe.trackvg.model.entity.Status;
import com.coe.trackvg.repository.StatusRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatusService {

  private final StatusRepository statusRepository;
  private final Mapper mapper;

  public List<StatusDto> getStatuses() {
    final List<Status> statusList = statusRepository.findAll();

    return mapper.map(statusList, StatusDto.class);
  }

  public void createStatus(final CreateStatusDto createStatusDto) {
    final Status status = Status
        .builder()
        .description(createStatusDto.getStatus())
        .build();

    statusRepository.saveAndFlush(status);
  }

  public void deleteStatus(final int statusId) {
    statusRepository.deleteById(statusId);
  }
}
