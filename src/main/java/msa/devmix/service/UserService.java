package msa.devmix.service;

import jakarta.validation.constraints.Min;
import msa.devmix.domain.board.Board;
import msa.devmix.domain.user.User;
import msa.devmix.dto.UserBoardsDto;
import msa.devmix.dto.UserWithPositionTechStackDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findById(Long userId);
    User findByUsername(String username);
    UserWithPositionTechStackDto getUserInfo(Long userId);


    List<UserBoardsDto> findUserBoards(Long userId, Pageable pageable);
}
