package com.examen.cristian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String enviarCorreoRegistro(String destinatario) {
        try {
            String asunto = "¡Tarea asignada!";
            String cuerpo = ""
                    + "<body style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; background-color: #f3f4f6; padding: 40px;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 30px; border-radius: 12px; box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);\">\r\n"
                    + "  <h1 style=\"font-size: 32px; font-weight: bold; color: #333333; text-align: center;\">¡Se te ha asignado una tarea!</h1>\r\n"
                    + "  <p style=\"font-size: 20px; color: #666666; text-align: center; margin-top: 20px;\">Te informamos que se te ha asignado una nueva tarea.</p>\r\n"
                    + "  <hr style=\"border: 0; border-top: 2px solid #eeeeee; margin: 30px 0;\">\r\n"
                    + "</div>\r\n"
                    + "<div style=\"text-align: center; margin-top: 20px; font-size: 14px; color: #888888;\">\r\n"
                    + "  <p>&copy; 2024. Todos los derechos reservados.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(destinatario, asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar " + e.getMessage();
        }
    }

    public boolean enviarCorreo(String destinatario, String asunto, String cuerpo) throws MessagingException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpo, true);

            javaMailSender.send(message);
            return true;
        } catch (Exception e) {

            return false;
        }

    }
}
