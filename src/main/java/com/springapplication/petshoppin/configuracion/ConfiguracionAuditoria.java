package com.springapplication.petshoppin.configuracion;

import com.springapplication.petshoppin.upload.StorageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EnableConfigurationProperties(StorageProperties.class)
public class ConfiguracionAuditoria {

}
