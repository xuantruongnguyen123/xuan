package com.poly.service.impl;

import javax.servlet.ServletContext;


import com.poly.entity.User;
import com.poly.service.EmailSerVice;
import com.poly.util.SendMailUtils;

public class EmailServiceImpl implements EmailSerVice {
private static final String EMAIL_WELLCOME_SUBJECT = "Wellcome to online Entertaiment";
private static final String EMAIL_FORGOT_PASSWORD = "Online Entertaiment- new password";
	@Override
	public void sendEmail(ServletContext context, User recipient, String type) {
		String host = context.getInitParameter("host");
		String port = context.getInitParameter("port");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");
		try {
			String content = null;
			String subject = null;
			switch (type) {
			case "wellcome": {
				subject= EMAIL_WELLCOME_SUBJECT;
				content= "Dear " +recipient.getUsername()+ " hope you have a good time!";
				break;
			}
			case "forgot" :{
				subject = EMAIL_FORGOT_PASSWORD;
				content =  "Dear " +recipient.getUsername()+ " your new password here:" + recipient.getPassword();
				break;
			}
			default:
				subject = "online Emtertaiment";
				content ="Maybe this Email is wrong, dont care about it";
			}
			SendMailUtils.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	

}
