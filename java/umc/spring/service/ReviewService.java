package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.MyMission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.ReviewRequestDto;
import umc.spring.repository.MyMissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MyMissionRepository myMissionRepository;
    private final StoreRepository storeRepository;

    public void addReview(ReviewRequestDto reviewRequestDto, String token) {
        // 토큰 인증 및 유효성 검증 로직 추가 필요

        // MyMission 객체 조회
        MyMission myMission = myMissionRepository.findById(reviewRequestDto.getMyMissionId())
                .orElseThrow(() -> new IllegalArgumentException("MyMission not found"));

        // Store 객체 조회
        Store store = storeRepository.findById(reviewRequestDto.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        // Review 객체 생성
        Review review = Review.builder()
                .myMission(myMission)
                .store(store)
                .content(reviewRequestDto.getContent())
                .rating(reviewRequestDto.getRating())
                .build();

        // Review 저장
        reviewRepository.save(review);
    }

}
