package world.kdj.kopoke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import world.kdj.kopoke.service.AdminNoticeService;

@RestController
@RequestMapping("/adminNotice")
public class AdminNoticeController {

    @Autowired
    private AdminNoticeService adminNoticeService;

    @PostMapping
    public void createAdminNotice(@RequestBody AdminNoticeRequest request) {
        adminNoticeService.createAdminNotice(request.getContent());
    }

    public static class AdminNoticeRequest {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
