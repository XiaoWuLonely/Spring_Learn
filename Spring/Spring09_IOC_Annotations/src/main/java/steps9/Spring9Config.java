package steps9;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"steps9.Dao", "steps9.service"})
public class Spring9Config {
}
