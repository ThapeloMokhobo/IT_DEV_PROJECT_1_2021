package za.ac.nwu.ac.Logic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.Translator.Config.TranslatorConfig;

@Import({TranslatorConfig.class})
@Configuration
@ComponentScan(basePackages = {"za.ac.nwu.ac.Logic.flow"})
public class LogicConfig {

}
