package ru.aridan.mailo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommRunner implements CommandLineRunner {

    private final MailSender mailSender;

    public CommRunner(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("start sending email");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("nobody@nowhere");
        simpleMailMessage.setText("Cъешь ещё этих мягких французских булок, да выпей чаю!");
        simpleMailMessage.setFrom("trolls@tree.com");
        simpleMailMessage.setSubject("pwned");
        mailSender.send(simpleMailMessage);
        logger.info("email sent");
    }
}
