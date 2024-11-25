package umc.spring.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MyMissionResponseDto {
    private Long myMissionId;
    private String missionName;
    private String status;
    private Date startedAt;
}
