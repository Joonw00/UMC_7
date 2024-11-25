package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.MyMission;

@Repository
public interface MyMissionRepository extends JpaRepository<MyMission, Long> {
}
