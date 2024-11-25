package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.dto.MissionResponseDto;
import umc.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public Page<MissionResponseDto> getMissionsByStore(Long storeId, int page) {
        return missionRepository.findByStoreStoreId(storeId, PageRequest.of(page, 10))
                .map(mission -> MissionResponseDto.builder()
                        .missionId(mission.getMissionId())
                        .missionName(mission.getMissionName())
                        .description(mission.getDescription())
                        .dueDate(mission.getDueDate())
                        .build());
    }
}
