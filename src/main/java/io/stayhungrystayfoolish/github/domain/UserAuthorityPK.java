package io.stayhungrystayfoolish.github.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@IdClass(UserAuthorityPK.class)
public class UserAuthorityPK implements Serializable {

    private static final long serializableUID = 1L;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotNull
    @Column(name = "authority_name", length = 50, nullable = false)
    private String authorityName;

    public UserAuthorityPK() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthorityPK)) return false;
        UserAuthorityPK that = (UserAuthorityPK) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
            Objects.equals(getAuthorityName(), that.getAuthorityName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getAuthorityName());
    }

    @Override
    public String toString() {
        return "UserAuthorityPK{" +
            "userId=" + userId +
            ", authorityName='" + authorityName + '\'' +
            '}';
    }
}
