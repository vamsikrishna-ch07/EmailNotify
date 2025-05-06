package com.flm.Email.EmailNotify;

import com.flm.Email.EmailNotify.notification.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmailNotifyApplicationTests {
	@Autowired
	private  EmailService emailService;
	@Test
	void testSendEmail() {
		emailService.SendEmail("vamsikrishnach0416@gmail.com", "Test Subject", "This is a test email.");
	}

}
