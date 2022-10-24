package com.coe.trackvg.service;

import com.coe.trackvg.mapper.Mapper;
import com.coe.trackvg.model.dto.CreatePlatformDto;
import com.coe.trackvg.model.dto.PlatformDto;
import com.coe.trackvg.model.entity.Platform;
import com.coe.trackvg.repository.PlatformRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlatformService {

  private final PlatformRepository platformRepository;
  private final Mapper mapper;


  public List<PlatformDto> getPlatforms() {
    final List<Platform> platformList = platformRepository.findAll();

    return mapper.map(platformList, PlatformDto.class);
  }

  public void createPlatform(CreatePlatformDto createPlatformDto) {
    final Platform newPlatform = Platform
        .builder()
        .description(createPlatformDto.getPlatform())
        .build();

    platformRepository.saveAndFlush(newPlatform);
  }

  public void deletePlatform(final int platformId) {
    platformRepository.deleteById(platformId);
  }
}
