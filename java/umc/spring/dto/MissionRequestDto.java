package umc.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionRequestDto {
    private Long storeId;
    private String missionName;
    private String description;
    private Date dueDate;
    private int requiredPrice;
    private int rewardPoints;
}
