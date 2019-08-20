package com.kechun.conf.log;

import com.kechun.conf.log.annotation.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LogConfig {

	@Bean(name = "logAspect")
	public LogAspect getLogAspect() {
		return new LogAspect();
	}

}
