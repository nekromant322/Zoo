package com.nekromant.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({
        "classpath:config/datasource.properties",
        "classpath:config/jpa.properties",
        "classpath:config/vkService.properties",
        "classpath:config/contacts.properties",
        "classpath:config/yandex.properties",
        "classpath:config/mail.properties",
        "classpath:config/sms.properties"
})
public class ZooApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooApplication.class, args);
    }

    //delete "//" to enable init userroles and users to base
}