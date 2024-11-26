package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.MyMission;
import umc.spring.domain.Store;
import umc.spring.domain.UserProfile;
import umc.spring.dto.MissionChallengeRequestDto;
import umc.spring.dto.MissionRequestDto;
import umc.spring.repository.MyMissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MyMissionRepository myMissionRepository;
    private final ReviewRepository.UserProfileRepository userProfileRepository;
    private final StoreRepository storeRepository;

    public void challengeMission(MissionChallengeRequestDto missionChallengeRequestDto) {
        UserProfile user = userProfileRepository.findFirstByOrderByUserIdAsc()
                .orElseThrow(() -> new IllegalStateException("No user found in the database"));

        // MyMission 객체 생성 및 저장
        MyMission myMission = MyMission.builder()
                .userId(user) // 하드코딩된 유저
                .missionId(missionChallengeRequestDto.getMissionId())
                .status("IN_PROGRESS")
                .startedAt(LocalDateTime.now())
                .build();

        myMissionRepository.save(myMission);
    }


    public void addMission(MissionRequestDto missionRequestDto) {
        Store store = storeRepository.findById(missionRequestDto.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        // Mission 생성
        Mission mission = Mission.builder()
                .store(store) // 연관된 Store 설정
                .missionName(missionRequestDto.getMissionName())
                .description(missionRequestDto.getDescription())
                .dueDate(missionRequestDto.getDueDate())
                .requiredPrice(missionRequestDto.getRequiredPrice())
                .rewardPoints(missionRequestDto.getRewardPoints())
                .build();

        // Mission 저장
        myMissionRepository.save(mission);
    }
}
