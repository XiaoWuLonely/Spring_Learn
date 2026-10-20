package steps8.Dao.impl;

import org.springframework.stereotype.Repository;
import steps8.Dao.Steps8_StudentDao;

@Repository
public class Steps8_StudentDaoImpl  implements Steps8_StudentDao  {
    @Override
    public void deleteById() {
        System.out.println("正在删除Steps8_StudentDao");
    }
}
