package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.custom.ValidPage;
import umc.spring.dto.MissionResponseDto;
import umc.spring.service.MissionService;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Tag(name = "Mission", description = "미션 관련 API")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/store/{storeId}")
    @Operation(summary = "가게 미션 목록", description = "특정 가게의 미션 목록을 페이징하여 반환합니다.")
    public ResponseEntity<Page<MissionResponseDto>> getMissionsByStore(
            @PathVariable Long storeId,
            @ValidPage int page) {
        Page<MissionResponseDto> missions = missionService.getMissionsByStore(storeId, page);
        return ResponseEntity.ok(missions);
    }
}
