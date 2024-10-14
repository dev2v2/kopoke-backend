package world.kdj.kopoke.mapper;

import world.kdj.kopoke.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    // 사용자를 데이터베이스에 삽입 (최초 로그인 시 호출)
    @Insert("INSERT INTO users (oauth_provider, oauth_id, name, email, role, created_at, updated_at) " +
            "VALUES (#{oauthProvider}, #{oauthId}, #{name}, #{email}, #{role}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insertUser(User user);

    // OAuth ID로 사용자 검색
    @Select("SELECT * FROM users WHERE oauth_id = #{oauthId}")
    User findByOauthId(String oauthId);

    // 이메일로 사용자 검색 (중복 이메일 검사를 위해)
    @Select("SELECT * FROM users WHERE email = #{email}")
    User findByEmail(String email);
}