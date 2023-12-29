package com.example.Library.service;

import com.example.Library.dto.CustomerFeedbackDto;
import com.example.Library.model.CustomerFeedback;

public interface CustomerFeedbackService {
    CustomerFeedback addFeedBack(CustomerFeedbackDto customerFeedbackDto);
}
