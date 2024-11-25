package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.custom.ValidPage;
import umc.spring.dto.MyMissionResponseDto;
import umc.spring.service.MyMissionService;

@RestController
@RequestMapping("/my-missions")
@RequiredArgsConstructor
@Tag(name = "MyMission", description = "진행 중인 미션 API")
public class MyMissionController {

    private final MyMissionService myMissionService;

    @GetMapping("/in-progress")
    @Operation(summary = "진행 중인 미션 목록", description = "내가 진행 중인 미션 목록을 페이징하여 반환합니다.")
    public ResponseEntity<Page<MyMissionResponseDto>> getInProgressMissions(@ValidPage int page) {
        Page<MyMissionResponseDto> missions = myMissionService.getInProgressMissions(page);
        return ResponseEntity.ok(missions);
    }
}
