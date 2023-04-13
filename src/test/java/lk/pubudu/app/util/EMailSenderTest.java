package lk.pubudu.app.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EMailSenderTest {

    @Mock
    private Environment env;
    @Mock
    private JavaMailSender javaMailSender;
    @InjectMocks
    private EMailSender eMailSender;

    @Test
    void sendMail() {
        SimpleMailMessage mail = new SimpleMailMessage();

        when(env.getProperty("spring.mail.username")).thenReturn("username");
        javaMailSender.send(mail);

        assertDoesNotThrow(() -> {
            eMailSender.sendMail("pubudu@gmail.com", "Test Mail", "Testing ...");
        });
    }
}