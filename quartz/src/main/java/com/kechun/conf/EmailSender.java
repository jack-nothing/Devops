package com.kechun.conf;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailSender implements Runnable {
    private String[] toUserArr;
    private String toUser;
    private String ccUser;
    private String[] ccUserArr;
    private String subject;
    private String content;
    private String fromUser;
    private JavaMailSenderImpl javaMailSender;

    public EmailSender(JavaMailSenderImpl javaMailSender, String ccUser, String toUser, String fromUser, String content, String subject) {
        this.toUser = toUser;
        this.ccUser = ccUser;
        this.subject = subject;
        this.content = content;
        this.fromUser = fromUser;
        this.javaMailSender = javaMailSender;
    }

    private MimeMessage SetMimeMessage() {
        MimeMessage mailMessage = null;
        try {
            mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true);
            messageHelper.setTo(toUser);
            messageHelper.setCc(ccUser);
            messageHelper.setFrom(fromUser);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mailMessage;
    }


    public void run() {
        MimeMessage mailMessage = SetMimeMessage();
        javaMailSender.send(mailMessage);
        System.out.println(123);
    }
}