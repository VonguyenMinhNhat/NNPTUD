package com.example.baitapngay10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class BaiTapNgay10Application {
    public static void main(String[] args) {
        SpringApplication.run(BaiTapNgay10Application.class, args);
    }
}
