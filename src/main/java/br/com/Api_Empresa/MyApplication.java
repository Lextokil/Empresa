package br.com.Api_Empresa;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
	
	public MyApplication() {
		packages("br.com.Api_Empresa.controller");
	}

}
