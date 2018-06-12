package com.example.soap;


import com.example.soap.student.ObjectFactory;
import com.example.soap.student.StudentModel;
import com.example.soap.student.StudentRequest;
import com.example.soap.student.StudentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.annotation.PostConstruct;

@Component
public class StudentClient {

    private final static String CONTEXT_PATH = "com.example.soap.student";

    @Value("${client.default-uri}")
    private String defaultUri;

    private WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    @PostConstruct
    private void init() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(CONTEXT_PATH);

        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri(defaultUri);
    }


    public StudentModel getStudentById(Integer id) {
        ObjectFactory factory = new ObjectFactory();

        StudentRequest request = factory.createStudentRequest();
        request.setId(id);

        StudentResponse response = (StudentResponse) webServiceTemplate.marshalSendAndReceive(request);

        return response.getStudent();
    }
}