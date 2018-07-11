package app.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmaiServiceImpl{
	
	 @Autowired
	  public JavaMailSender emailSender;
	 
	 public void sendSimpleMessage(String to, String subject, String text) {

	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
	    }

	 
	 public void sendInvitation(String email,String url,String userEmail) {
		 String subject = "Invitation to join Gabi's Company";
		 String text = "Hello! \n " + userEmail 
				+" invited you to join on our platform. \n"
		 		+ "Please click on the following URL:"
		 		+ " \n to join your team.\n "+url;
		 
		 sendSimpleMessage(email, subject, text);
	 }
	 
}
