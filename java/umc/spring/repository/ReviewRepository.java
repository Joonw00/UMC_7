package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Review;
import umc.spring.domain.UserProfile;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Repository
    interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

        Optional<UserProfile> findFirstByOrderByUserIdAsc();
    }
}
