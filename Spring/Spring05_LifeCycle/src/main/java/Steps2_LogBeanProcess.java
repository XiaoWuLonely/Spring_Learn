import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Steps2_LogBeanProcess implements BeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean before");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }


    // 方法有两个参数:
// 第一个参数:刚创建的bean对象。
// 第二个参数:bean的名字。
    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean after");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
