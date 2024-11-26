package umc.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.dto.ReviewRequestDto;
import umc.spring.service.ReviewService;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Tag(name = "Review", description = "리뷰 관련 API")
public class ReviewController {

    private final ReviewService reviewService;

    @Operation(summary = "리뷰 추가", description = "특정 가게에 대해 리뷰를 추가합니다.")
    @PostMapping
    public ResponseEntity<String> addReview(
            @RequestBody @Parameter(description = "리뷰 추가 요청 데이터", required = true) ReviewRequestDto reviewRequestDto,
            @RequestHeader("Authorization") @Parameter(description = "JWT 토큰", required = true) String token) {
        reviewService.addReview(reviewRequestDto, token);
        return ResponseEntity.ok("Review added successfully!");
    }
}
