package auth.auth.domain.users;

public record RegisterDTO(String login, String password, UserRole role) {
}
