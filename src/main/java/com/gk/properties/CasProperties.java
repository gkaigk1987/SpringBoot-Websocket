package com.gk.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="cas")//该注解配置需要配合@EnableConfigurationProperties使用，1.5后取消了location属性
@PropertySource(value="classpath:/prop/cas.properties")
public class CasProperties {

	private String clientName;
	
	private Map<String, String> server;
	
	private Map<String, String> project;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Map<String, String> getServer() {
		return server;
	}

	public void setServer(Map<String, String> server) {
		this.server = server;
	}

	public Map<String, String> getProject() {
		return project;
	}

	public void setProject(Map<String, String> project) {
		this.project = project;
	}
	
}
