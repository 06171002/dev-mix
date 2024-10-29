package msa.devmix.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msa.devmix.domain.user.User;
import msa.devmix.domain.user.UserTechStack;
import msa.devmix.dto.UserWithPositionTechStackDto;
import msa.devmix.exception.CustomException;
import msa.devmix.exception.ErrorCode;
import msa.devmix.repository.UserPositionRepository;
import msa.devmix.repository.UserRepository;
import msa.devmix.repository.UserTechStackRepository;
import msa.devmix.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserPositionRepository userPositionRepository;
    private final UserTechStackRepository userTechStackRepository;

    //유저 ID로 유저 엔티티 조회
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    //username 으로 user 테이블에서 유저를 찾고, 없으면 예외 발생
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }

    //사용자 정보 및 관련된 기술 스택 & 포지션 정보 조회
    public UserWithPositionTechStackDto getUserInfo(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        userTechStackRepository.findByUser(user);
        userPositionRepository.findByUser(user);
        return null;
    }
}
