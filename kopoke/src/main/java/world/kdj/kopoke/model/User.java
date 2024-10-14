package world.kdj.kopoke.model;

import java.sql.Timestamp;

public class User {
    private Long userId; // 사용자 고유 ID
    private String oauthProvider; // OAuth 제공자 (예: Google)
    private String oauthId; // OAuth에서 제공하는 고유 사용자 ID
    private String name; // 사용자 이름
    private String email; // 이메일
    private String role; // 역할 (admin, user 등)
    private Timestamp createdAt; // 가입 일자
    private Timestamp updatedAt; // 마지막 업데이트 일자

    // 모든 필드를 초기화하는 생성자
    public User(Long userId, String oauthProvider, String oauthId, String name, String email, String role,
            Timestamp createdAt, Timestamp updatedAt) {
        this.userId = userId;
        this.oauthProvider = oauthProvider;
        this.oauthId = oauthId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // 필수 필드만 초기화하는 생성자 (role, createdAt, updatedAt은 기본값 사용)
    public User(String oauthProvider, String oauthId, String name, String email) {
        this.oauthProvider = oauthProvider;
        this.oauthId = oauthId;
        this.name = name;
        this.email = email;
        this.role = "user"; // 기본값 'user' 설정
        this.createdAt = new Timestamp(System.currentTimeMillis()); // 현재 시간으로 설정
        this.updatedAt = new Timestamp(System.currentTimeMillis()); // 현재 시간으로 설정
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOauthProvider() {
        return oauthProvider;
    }

    public void setOauthProvider(String oauthProvider) {
        this.oauthProvider = oauthProvider;
    }

    public String getOauthId() {
        return oauthId;
    }

    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

}