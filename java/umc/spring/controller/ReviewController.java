package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.custom.ValidPage;
import umc.spring.dto.ReviewResponseDto;
import umc.spring.service.ReviewService;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Tag(name = "Review", description = "리뷰 관련 API")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/my")
    @Operation(summary = "내 리뷰 목록", description = "내가 작성한 리뷰 목록을 페이징하여 반환합니다.")
    public ResponseEntity<Page<ReviewResponseDto>> getMyReviews(@ValidPage int page) {
        Page<ReviewResponseDto> reviews = reviewService.getMyReviews(page);
        return ResponseEntity.ok(reviews);
    }
}
