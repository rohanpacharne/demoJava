package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MessageDao;

@Service
public class MessageService {
	
	@Autowired
	MessageDao messageDao;
	
	public String getMessageNameByCode(String messageCode) {
		
		return messageDao.getMessageNameByCode(messageCode);
	}

}
