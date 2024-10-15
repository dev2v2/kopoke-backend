package world.kdj.kopoke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import world.kdj.kopoke.mapper.AdminNoticeMapper;
import world.kdj.kopoke.model.AdminNotice;

import java.time.LocalDateTime;

@Service
public class AdminNoticeService {

    @Autowired
    private AdminNoticeMapper adminNoticeMapper;

    public void createAdminNotice(String content) {
        AdminNotice adminNotice = new AdminNotice();
        adminNotice.setContent(content);
        adminNotice.setCreatedAt(LocalDateTime.now());
        adminNoticeMapper.insertAdminNotice(adminNotice);
    }
}
