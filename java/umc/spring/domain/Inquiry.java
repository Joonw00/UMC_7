package umc.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.common.BaseEntity;

import java.util.Date;

@Entity
@Getter
@Setter
public class Inquiry extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquiryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 255)
    private String content;

    @Column(length = 50)
    private String type;

    @Column(length = 255)
    private String attachedImage;
}
