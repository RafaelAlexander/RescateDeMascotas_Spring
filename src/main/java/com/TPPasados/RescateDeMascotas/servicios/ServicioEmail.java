package com.TPPasados.RescateDeMascotas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ServicioEmail {
    @Value("${spring.mail.username}")
    private String emailFrom;

    @Autowired
    private JavaMailSender mail;

    public void envioMensaje(String msg, String title, String emailTo) {
        SimpleMailMessage smm = new SimpleMailMessage();
        String email = emailTo;
        smm.setTo(email);
        smm.setFrom(this.emailFrom);
        smm.setSubject(title);
        smm.setText(msg);
        mail.send(smm);
    }
}
