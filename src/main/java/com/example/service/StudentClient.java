package com.example.service;


import com.example.students.GetStudentDetailsRequest;
import com.example.students.GetStudentDetailsResponse;
import com.example.students.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class StudentClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public String sayHello(Integer id) {
        ObjectFactory factory = new ObjectFactory();
        GetStudentDetailsRequest request = factory.createGetStudentDetailsRequest();

        request.setId(id);

        GetStudentDetailsResponse response = (GetStudentDetailsResponse) webServiceTemplate.marshalSendAndReceive(request);

        System.out.println("Got Response As below ========= : ");
        System.out.println("Standard : "+response.getStudentDetails().getId());
        System.out.println("Name : "+response.getStudentDetails().getName());
        System.out.println("Address : "+response.getStudentDetails().getPassportNumber());

        return response.getStudentDetails().getName();
    }
}