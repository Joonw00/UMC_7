package umc.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.common.BaseEntity;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class UserProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column
    private Date birthDate;

    @Column(length = 255)
    private String address;

    @Column(nullable = false)
    private int points;

    // 연관 관계 설정
    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<UserPreferences> preferences;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<NotificationSettings> notificationSettings;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<MyMission> myMissions;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<Inquiry> inquiries;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<TermsAgreement> agreements;
}
