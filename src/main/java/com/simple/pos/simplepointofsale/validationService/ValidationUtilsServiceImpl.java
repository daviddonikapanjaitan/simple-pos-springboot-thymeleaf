package com.simple.pos.simplepointofsale.validationService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.simple.pos.simplepointofsale.model.PaymentMethod;
import com.simple.pos.simplepointofsale.service.PaymentMethodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationUtilsServiceImpl implements ValidationUtilsService{

    @Autowired
    PaymentMethodService paymentMethodService;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @Override
    public boolean checkPaymentMethod(String paymentCode) {
        boolean returnResult = false;
        List<PaymentMethod> lMethods = paymentMethodService.getAllPaymentMethod();

        for (PaymentMethod paymentMethod : lMethods) {
            if(paymentMethod.getPaymentMethodCode().equalsIgnoreCase(paymentCode)){
                returnResult = true;
            }
        }

        return returnResult;
    }

    @Override
    public boolean phoneValidation(String phone) {
        return phone.matches("[0-9]+");
    }
}
