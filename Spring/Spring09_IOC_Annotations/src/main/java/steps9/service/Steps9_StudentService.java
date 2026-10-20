package steps9.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import steps8.Dao.Steps8_StudentDao;
import steps9.Dao.Steps9_StudentDao;

@Service
public class Steps9_StudentService {
    @Resource(name = "steps9_StudentDaoImpl")
    private Steps9_StudentDao steps9StudentDao;

    public void deleteStudent() {
        steps9StudentDao.deleteById();
    }
}
