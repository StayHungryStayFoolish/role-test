package io.stayhungrystayfoolish.github.domain;


import com.sun.scenario.effect.impl.prism.PrRenderInfo;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "jhi_user_authority")
public class UserAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserAuthorityPK userAuthorityPK;


    public UserAuthorityPK getUserAuthorityPK() {
        return userAuthorityPK;
    }

    public void setUserAuthorityPK(UserAuthorityPK userAuthorityPK) {
        this.userAuthorityPK = userAuthorityPK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthority)) return false;
        UserAuthority that = (UserAuthority) o;
        return Objects.equals(getUserAuthorityPK(), that.getUserAuthorityPK());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserAuthorityPK());
    }

    @Override
    public String toString() {
        return "UserAuthority{" +
            "userAuthorityPK=" + userAuthorityPK +
            '}';
    }
}
