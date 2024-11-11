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
public class Terms extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termsId;

    @Column(nullable = false, length = 100)
    private String termsTitle;

    @Column(length = 500)
    private String termsContent;

    @Column
    private Date effectiveDate;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<TermsAgreement> agreements;
}
