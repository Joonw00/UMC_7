package umc.spring.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MissionResponseDto {
    private Long missionId;
    private String missionName;
    private String description;
    private Date dueDate;
}
