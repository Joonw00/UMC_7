package umc.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Setter
public class UserPreferences extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userPreferenceId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private PreferenceType preferenceType;
}
