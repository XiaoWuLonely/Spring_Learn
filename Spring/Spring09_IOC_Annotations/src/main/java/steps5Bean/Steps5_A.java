package steps5Bean;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class Steps5_A {

    public Steps5_A() {
        System.out.println("A");
    }
}

@Service
class B {

    public B() {
        System.out.println("B");
    }
}

@Controller
class C {

    public C() {
        System.out.println("C");
    }
}

@Repository
class D {

    public D() {
        System.out.println("D");
    }
}

@Controller
class E {

    public E() {
        System.out.println("E");
    }
}