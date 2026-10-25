import Steps3.service.Steps3_UserService;
import Steps3.util.Steps3_MethodInterceptor;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

public class Steps3_Action {

    @Test
    public void Action1() {
        // 创建字节码增强器对象
        //这个对象是CGLIB库当中的核心对象,就是依靠它来生成代理类。
        Enhancer enhancer = new Enhancer();
        // 告诉CGLIB父类是谁。告诉CGLIB目标类是谁。
        enhancer.setSuperclass(Steps3_UserService.class);
        // 设置回调(等同于JDK动态代理当中的调用处理器。InvocationHandLer)
        // 在CGLIB当中不是InvocationHandler接口,是方法拦截器接口:MethodInterceptor
        enhancer.setCallback(new Steps3_MethodInterceptor());

        // 创建代理对象
        // 这一步会做两件事:
        // 第一件事:在内存中生成UserService类的子类,其实就是代理类的字节码。
        // 第二件事:创建代理对象。
        // 父类是UserService,子类这个代理类一定是UserService
        Steps3_UserService steps3UserService = (Steps3_UserService) enhancer.create();
        System.out.println(steps3UserService);
        //调用方法
        boolean login = steps3UserService.login("admin", "wulong");
        System.out.println(login ? "Succeed" : "fail");

        steps3UserService.logout();
    }
}
