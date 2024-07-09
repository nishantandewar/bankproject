package com.nishant.bankproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nishant.bankproject.dto.EmaiDetails;

@Service
public class EmailServiceimpl implements EmailService {
    
	@Autowired
	private JavaMailSender javamailsender;
	
	@Value("${spring.mail.username}")
	private String sendermail;

	@Override
	public void emailsender(EmaiDetails emailDetails) {
		try {
			SimpleMailMessage message=new SimpleMailMessage();
			message.setFrom(sendermail);
			message.setTo(emailDetails.getReceipent());
			message.setText(emailDetails.getMessagebody());
			message.setSubject(emailDetails.getSubject());
			
			javamailsender.send(message);
			System.out.println("mail sent successfully");
		}
		catch(MailException e) {
			throw new RuntimeException(e);
		}
	}
}
