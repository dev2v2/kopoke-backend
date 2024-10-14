package world.kdj.kopoke.service;

import world.kdj.kopoke.mapper.UserMapper;
import world.kdj.kopoke.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 사용자를 저장하는 메서드 (최초 로그인 시 호출)
    public void registerUser(User user) {
        // 사용자 정보가 이미 존재하는지 확인
        User existingUser = userMapper.findByOauthId(user.getOauthId());
        if (existingUser == null) {
            // 사용자 정보가 없으면 새로 저장
            userMapper.insertUser(user);
        }
    }

    // 이메일로 사용자 정보 찾기 (중복 체크용)
    public User getUserByEmail(String email) {
        return userMapper.findByEmail(email);
    }
}
