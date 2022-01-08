package moee.henaknowledge.service;


import moee.henaknowledge.module.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SmtpMailSender {

    @Autowired
    private JavaMailSender jms;

    @Async
    public void sendTextEmail(Email email) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setTo(email.getTo());
        simpleMessage.setSubject(email.getSubject());
        simpleMessage.setText(email.getText());
        jms.send(simpleMessage);
    }

}
