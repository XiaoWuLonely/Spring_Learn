package steps8.service;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import steps8.Dao.Steps8_StudentDao;

@Service
public class Steps8_StudentService {
    //@Autowired 是 Spring 提供的，默认按“类型（ByType）”找。
    //@Resource 是 Java 官方（JSR-250）提供的，默认按“名字（ByName）”找。
    @Resource(name = "steps8_StudentDaoImpl")
    private Steps8_StudentDao steps8_studentDao;

    public void deleteStudent() {
        steps8_studentDao.deleteById();
    }
}
