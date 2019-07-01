package com.document;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.document.mapper")
public class DocumentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentManagerApplication.class, args);
    }
}
