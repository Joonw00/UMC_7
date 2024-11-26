package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.dto.MissionChallengeRequestDto;
import umc.spring.dto.MissionRequestDto;
import umc.spring.service.MissionService;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;
    @PostMapping
    public ResponseEntity<String> addMission(@RequestBody MissionRequestDto missionRequestDto) {
        missionService.addMission(missionRequestDto);
        return ResponseEntity.ok("Mission added successfully!");
    }
    @PostMapping("/challenge")
    public ResponseEntity<String> challengeMission(@RequestBody MissionChallengeRequestDto missionChallengeRequestDto) {
        missionService.challengeMission(missionChallengeRequestDto);
        return ResponseEntity.ok("Mission challenged successfully!");
    }
}
