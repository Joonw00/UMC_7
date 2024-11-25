package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.dto.MyMissionResponseDto;
import umc.spring.repository.MyMissionRepository;

@Service
@RequiredArgsConstructor
public class MyMissionService {

    private final MyMissionRepository myMissionRepository;

    public Page<MyMissionResponseDto> getInProgressMissions(int page) {
        Long userId = 1L;

        return myMissionRepository.findByUserProfileUserIdAndStatus(userId, "IN_PROGRESS", PageRequest.of(page, 10))
                .map(myMission -> MyMissionResponseDto.builder()
                        .myMissionId(myMission.getMyMissionId())
                        .missionName(myMission.getMission().getMissionName())
                        .status(myMission.getStatus())
                        .startedAt(myMission.getStartedAt())
                        .build());
    }
}
