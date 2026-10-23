import org.junit.jupiter.api.Test;
import service.Steps1_OrderService;
import service.impl.Steps1_OrderServiceImpl;
import service.impl.Steps1_OrderServiceImplSub;
import service.impl.Steps1_OrderServiceProxy;

public class Steps1_Action {

    @Test
    public void Action1(){
//        Steps1_OrderServiceImpl orderService = new Steps1_OrderServiceImpl();
//        orderService.generate();
//        orderService.modify();
//        orderService.detail();

//        Steps1_OrderServiceImpl orderService = new Steps1_OrderServiceImplSub();
//        orderService.generate();
//        orderService.modify();
//        orderService.detail();

        Steps1_OrderService target = new Steps1_OrderServiceImpl();
        Steps1_OrderService proxy = new Steps1_OrderServiceProxy(target);
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
