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
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false, length = 100)
    private String missionName;

    @Column(length = 255)
    private String description;

    @Column
    private Date dueDate;

    @Column
    private int requiredPrice;

    @Column
    private int rewardPoints;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MyMission> myMissions;
}
