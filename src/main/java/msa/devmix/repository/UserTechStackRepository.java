package msa.devmix.repository;

import msa.devmix.domain.user.User;
import msa.devmix.domain.user.UserPosition;
import msa.devmix.domain.user.UserTechStack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTechStackRepository extends JpaRepository<UserTechStack, Long> {

    //N+1 문제 해결 X
    List<UserTechStack> findByUser(User user);

    //N+1 문제 해결 O
}
