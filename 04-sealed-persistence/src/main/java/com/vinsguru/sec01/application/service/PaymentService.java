package com.vinsguru.sec01.application.service;

import com.vinsguru.sec01.application.model.Payment;
import com.vinsguru.sec01.persistence.entity.PaymentEntity;
import com.vinsguru.sec01.persistence.repository.PaymentRepository;
import com.vinsguru.sec01.application.util.DomainEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository repository;

    public void save(Payment payment) {
        var entity = DomainEntityMapper.toEntity(payment);
        this.repository.save(entity);
        log.info("payment saved successfully");
    }

    public Payment getPayment(Integer id) {
        return this.repository.findById(id)
                              .map(DomainEntityMapper::toDomain)
                              .orElseThrow();
    }

    public void printAllRecords() {
        this.repository.findAll()
                       .stream()
                       .map(PaymentEntity::toString)
                       .forEach(log::info);
    }

}
