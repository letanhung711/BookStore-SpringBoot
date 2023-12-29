package com.example.Library.service;

import com.example.Library.dto.MailNewsDto;
import com.example.Library.model.EmailNews;

public interface EmailNewsService {
    EmailNews addNew(MailNewsDto mailNewsDto);
}
