package za.ac.nwu.ac.web.sb.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.Logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.web.sb.Controller",
        "za.ac.nwu.ac.web.sb.exception"
})
public class webConfig {


}
