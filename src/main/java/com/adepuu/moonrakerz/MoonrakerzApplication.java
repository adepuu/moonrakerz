package com.adepuu.moonrakerz;

import com.adepuu.moonrakerz.config.RsaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaConfiguration.class)
@SpringBootApplication
public class MoonrakerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoonrakerzApplication.class, args);
	}

}
