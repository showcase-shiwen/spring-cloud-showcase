package org.showcase.service.system.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"org.showcase.common.config.rest","org.showcase.common.config.logconfig"})
public class PluginConfig {
}
