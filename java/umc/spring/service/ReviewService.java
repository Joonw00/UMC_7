package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.dto.ReviewResponseDto;
import umc.spring.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Page<ReviewResponseDto> getMyReviews(int page) {
        Long userId = 1L;

        return reviewRepository.findByUserProfileUserId(userId, PageRequest.of(page, 10))
                .map(review -> ReviewResponseDto.builder()
                        .reviewId(review.getReviewId())
                        .content(review.getContent())
                        .rating(review.getRating())
                        .storeName(review.getStore().getStoreName())
                        .build());
    }
}
