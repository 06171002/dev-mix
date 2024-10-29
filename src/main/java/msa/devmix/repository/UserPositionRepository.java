package msa.devmix.repository;

import msa.devmix.domain.user.User;
import msa.devmix.domain.user.UserPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPositionRepository extends JpaRepository<UserPosition, Long> {

    //N+1 문제 해결 X
    List<UserPosition> findByUser(User user);

    //N+1 문제 해결 O
}
