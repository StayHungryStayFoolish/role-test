package io.stayhungrystayfoolish.github.web.rest;

import io.stayhungrystayfoolish.github.domain.UserAuthority;
import io.stayhungrystayfoolish.github.domain.UserAuthorityPK;
import io.stayhungrystayfoolish.github.repository.UserAuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class RelationResource {

    @Autowired
    private UserAuthorityRepository repository;

    @GetMapping("/relation/{userId}")
    public List<UserAuthority> getInfo(@PathVariable Long userId) {
        List<UserAuthority> authority = repository.findByUserAuthorityPKUserId(userId);
        for (int i = 0; i < authority.size(); i++) {
            UserAuthority relation = authority.get(i);
            System.out.println(" -- " + relation);
            repository.deleteByUserAuthorityPK(relation.getUserAuthorityPK());
        }
        return authority;
    }

    @PutMapping("/relation")
    public UserAuthority updateAuthority() {
        UserAuthority authority = new UserAuthority();
        UserAuthorityPK pk = new UserAuthorityPK();
        pk.setUserId(3L);
        pk.setAuthorityName("ROLE_FREEZE");
        authority.setUserAuthorityPK(pk);
        repository.save(authority);
        return authority;
    }
}
