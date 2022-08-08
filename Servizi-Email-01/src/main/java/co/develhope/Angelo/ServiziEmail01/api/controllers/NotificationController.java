package co.develhope.Angelo.ServiziEmail01.api.controllers;

import co.develhope.Angelo.ServiziEmail01.api.entities.NotificationDTO;
import co.develhope.Angelo.ServiziEmail01.emailServices.EmailService;
import co.develhope.Angelo.ServiziEmail01.user.entities.Student;
import co.develhope.Angelo.ServiziEmail01.user.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmailService emailService;

    //exposes under the mapping notification an endpoint for sending an email to a specific Student
    @PostMapping("/notification")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDTO payload) {
        try {
            Student studentToSendNotification = studentService.getStudentById(payload.getContactId());
            System.out.println("Getting the student: " + studentToSendNotification);
            if (studentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not finder the student");
            }
            emailService.sendTo(studentToSendNotification.getEmail(), payload.getTitle(), payload.getText() );
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            //System.err.println("Error in notification controller" + e.getMessage());
            //e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The server is broken");
        }
    }
}
