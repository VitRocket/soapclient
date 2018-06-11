package com.example.service;

import com.example.students.GetStudentDetailsRequest;
import com.example.students.GetStudentDetailsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            String name = "Sajal";//Default Name
            if(args.length>0){
                name = args[0];
            }
            GetStudentDetailsRequest request = new GetStudentDetailsRequest();
            request.setId(1);
            GetStudentDetailsResponse response =(GetStudentDetailsResponse) soapConnector.callWebService("http://localhost:8181/ws", request);
            System.out.println("Got Response As below ========= : ");
            System.out.println("Standard : "+response.getStudentDetails().getId());
            System.out.println("Name : "+response.getStudentDetails().getName());
            System.out.println("Address : "+response.getStudentDetails().getPassportNumber());
        };
    }
}