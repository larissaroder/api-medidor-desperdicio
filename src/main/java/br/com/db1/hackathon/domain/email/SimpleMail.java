package br.com.db1.hackathon.domain.email;


import java.util.Properties;

import javax.mail.Session;

public class SimpleMail {

    public static void sendMail() {

        System.out.println("SimpleEmail Start");

        String smtpHostServer = "smtp.gmail.com";
        String emailID = "larissaroder@gmail.com";

        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtpHostServer);

        Session session = Session.getInstance(props, null);

        MailUtil.sendEmail(session, emailID, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
    }

}
