package steps9.Dao.impl;

import org.springframework.stereotype.Repository;
import steps8.Dao.Steps8_StudentDao;
import steps9.Dao.Steps9_StudentDao;

@Repository(value = "steps9_StudentDaoImpl")
public class Steps9_StudentDaoImpl implements Steps9_StudentDao {
    @Override
    public void deleteById() {
        System.out.println("嘎达嘎达！正在删除Steps9_StudentDaoImpl");
    }
}
