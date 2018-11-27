package io.stayhungrystayfoolish.github.web.rest;

import io.github.jhipster.web.util.ResponseUtil;
import io.stayhungrystayfoolish.github.domain.Role;
import io.stayhungrystayfoolish.github.domain.UserAuthority;
import io.stayhungrystayfoolish.github.domain.UserAuthorityPK;
import io.stayhungrystayfoolish.github.repository.UserAuthorityRepository;
import io.stayhungrystayfoolish.github.service.RoleService;
import io.stayhungrystayfoolish.github.service.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class RelationResource {

    @Autowired
    private UserAuthorityRepository repository;

    @Autowired
    private RoleService roleService;

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

    @GetMapping("/roleName/{roleName}")
    public ResponseEntity<RoleDTO> getRoleByRoleName(@PathVariable String roleName) {
        RoleDTO roleDTO =  roleService.findByRoleName(roleName);
        return ResponseEntity.ok().body(roleDTO);
    }
}
