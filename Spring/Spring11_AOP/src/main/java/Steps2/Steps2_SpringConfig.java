package Steps2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"Steps2"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Steps2_SpringConfig {
}
