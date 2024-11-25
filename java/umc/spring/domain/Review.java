package umc.spring.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @OneToOne
    @JoinColumn(name = "my_mission_id")
    private MyMission myMission;

    @Column(length = 255)
    private String content;

    @Column
    private int rating;

    // 빌더 추가
    @Builder
    public Review(Long reviewId, UserProfile userProfile, Store store, MyMission myMission, String content, int rating) {
        this.reviewId = reviewId;
        this.userProfile = userProfile;
        this.store = store;
        this.myMission = myMission;
        this.content = content;
        this.rating = rating;
    }
}
