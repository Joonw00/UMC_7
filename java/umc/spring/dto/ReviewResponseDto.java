package umc.spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponseDto {
    private Long reviewId;
    private String content;
    private int rating;
    private String storeName;
}
