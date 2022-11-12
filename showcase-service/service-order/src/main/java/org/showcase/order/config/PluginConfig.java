package org.showcase.order.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"org.showcase.common.config.feign","org.showcase.common.config.logconfig"})
public class PluginConfig {
}
