package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.EmailDetails;

public interface EmailService {
    public String sendSimpleMail(EmailDetails details);
}
