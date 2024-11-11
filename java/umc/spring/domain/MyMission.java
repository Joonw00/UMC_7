package umc.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.common.BaseEntity;

import java.util.Date;

@Entity
@Getter
@Setter
public class MyMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myMissionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(length = 50)
    private String status;

    @Column
    private Date startedAt;

    @Column
    private Date completedAt;

    @OneToOne(mappedBy = "myMission", cascade = CascadeType.ALL)
    private Review review;
}