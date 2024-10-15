package world.kdj.kopoke.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import world.kdj.kopoke.model.AdminNotice;

import java.util.List;

@Mapper
public interface AdminNoticeMapper {

    @Insert("INSERT INTO admin_notices (content, created_at) VALUES (#{content}, #{createdAt})")
    void insertAdminNotice(AdminNotice adminNotice);

    @Select("SELECT * FROM admin_notices ORDER BY created_at DESC")
    List<AdminNotice> getAllAdminNotices();
}
