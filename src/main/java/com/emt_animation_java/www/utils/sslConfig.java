package com.emt_animation_java.www.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.core.io.Resource;

@Configuration
public class sslConfig {

    @Value("classpath:emtanimation.fun.jks")
    private String keyStore= "classpath:emtanimation.fun.jks";

    @Value("vxl96nmo")
    private String keyStorePassword="vxl96nmo";


    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            connector.setScheme("https");
            connector.setSecure(true);
            connector.setPort(8080);

            connector.setAttribute("SSLEnabled", true);
            connector.setAttribute("keystorePass", keyStorePassword);
            connector.setAttribute("keystoreFile", keyStore);
        });
        return tomcat;
    }
}
