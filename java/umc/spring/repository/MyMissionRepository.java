package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.MyMission;

public interface MyMissionRepository extends JpaRepository<MyMission, Long> {
    Page<MyMission> findByUserProfileUserIdAndStatus(Long userId, String status, Pageable pageable);
}
