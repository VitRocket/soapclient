package com.example;

import com.example.soap.StudentClient;
import com.example.soap.model.StudentModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DemoWorker implements ApplicationRunner {

    private final StudentClient studentClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        StudentModel studentModel = studentClient.getStudentById(1);
        log.info(studentModel.toString());
        // Exit
        System.exit(1);
    }
}
