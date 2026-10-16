import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Steps5_DateFactory implements FactoryBean<Date> {
    // DateFactoryBean这个工/Bean协助我们Spring创建这个普通的Bean:Date。
    private String strBirth;

    public Steps5_DateFactory(String strBirth) {
        this.strBirth = strBirth;
    }


    @Override
    public @Nullable Date getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(strBirth);
        return date;
    }

    @Override
    public @Nullable Class<?> getObjectType() {
        return null;
    }
}
