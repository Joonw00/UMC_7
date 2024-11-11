package umc.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.common.BaseEntity;

import java.util.List;

@Entity
@Getter
@Setter
public class NotificationType extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @Column(nullable = false, length = 50)
    private String typeName;

    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "notificationType", cascade = CascadeType.ALL)
    private List<NotificationSettings> settings;
}
