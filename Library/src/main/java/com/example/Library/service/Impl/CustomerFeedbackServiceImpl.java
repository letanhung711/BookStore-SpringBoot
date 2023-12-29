package com.example.Library.service.Impl;

import com.example.Library.dto.CustomerFeedbackDto;
import com.example.Library.model.CustomerFeedback;
import com.example.Library.repository.CustomerFeedbackRepository;
import com.example.Library.service.CustomerFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerFeedbackServiceImpl implements CustomerFeedbackService {
    @Autowired
    private CustomerFeedbackRepository customerFeedbackRepository;
    @Override
    public CustomerFeedback addFeedBack(CustomerFeedbackDto customerFeedbackDto) {
        CustomerFeedback customerFeedback = new CustomerFeedback();
        customerFeedback.setName(customerFeedbackDto.getName());
        customerFeedback.setEmail(customerFeedbackDto.getEmail());
        customerFeedback.setFeedback(customerFeedbackDto.getFeedback());
        customerFeedbackRepository.save(customerFeedback);
        return customerFeedback;
    }
}
