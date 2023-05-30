package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class FileUploadingAndDownloadingProjectApplication {
	
	@Bean
	public ViewResolver resolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getResolver() {
		CommonsMultipartResolver res= new CommonsMultipartResolver();
		res.setMaxUploadSize(50*1024*1024);
		res.setMaxUploadSize(-1);
		return res;
	}

	public static void main(String[] args) {
		SpringApplication.run(FileUploadingAndDownloadingProjectApplication.class, args);
	}

}
