package io.stayhungrystayfoolish.github.repository;

import io.stayhungrystayfoolish.github.domain.UserAuthority;
import io.stayhungrystayfoolish.github.domain.UserAuthorityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, UserAuthorityPK> {

    @Modifying
    @Transactional
    void deleteByUserAuthorityPK(UserAuthorityPK userId);

    List<UserAuthority> findByUserAuthorityPKUserId(Long userId);

}
