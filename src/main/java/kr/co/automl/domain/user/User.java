package kr.co.automl.domain.user;

import kr.co.automl.domain.user.dto.SessionUser;
import lombok.Builder;

public class User {
    private final String name;
    private final String imageUrl;
    private final String email;
    private final Role role;
    private Long id;

    @Builder
    User(String name, String imageUrl, String email, Role role) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.email = email;
        this.role = role;
    }

    public static User ofDefaultRole(String name, String imageUrl, String email) {
        return User.builder()
                .name(name)
                .imageUrl(imageUrl)
                .email(email)
                .role(Role.USER)
                .build();
    }

    public SessionUser toSessionUser() {
        return new SessionUser(name, imageUrl, email);
    }
}