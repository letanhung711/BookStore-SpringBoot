package com.example.Library.service.Impl;

import com.example.Library.dto.MailNewsDto;
import com.example.Library.model.EmailNews;
import com.example.Library.repository.EmailNewsRepository;
import com.example.Library.service.EmailNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailNewsServiceImpl implements EmailNewsService {
    @Autowired
    private EmailNewsRepository emailNewsRepository;
    @Override
    public EmailNews addNew(MailNewsDto mailNewsDto) {
        EmailNews emailNews = new EmailNews();
        emailNews.setEmail(mailNewsDto.getEmail());
        emailNewsRepository.save(emailNews);
        return emailNews;
    }
}
