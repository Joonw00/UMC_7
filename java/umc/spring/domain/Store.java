package umc.spring.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.common.BaseEntity;

import java.util.List;

@Entity
@Getter
@Setter
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false, length = 100)
    private String storeName;

    @Column(length = 50)
    private String category;

    @Column(length = 255)
    private String address;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missions;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviews;
}
