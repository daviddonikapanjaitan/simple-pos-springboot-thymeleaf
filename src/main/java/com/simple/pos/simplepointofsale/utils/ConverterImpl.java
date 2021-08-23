package com.simple.pos.simplepointofsale.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConverterImpl implements ConverterService {

    private static Logger logger = LoggerFactory.getLogger(ConverterImpl.class);

    @Override
    public String dateToString(Date dateInput, String format) {
        try{
            logger.info("Date Input[ConverterImpl|dateToString]: {}", dateInput);
            logger.info("Date format[ConverterImpl|dateToString]: {}", format);

            Format formatter = new SimpleDateFormat(format);
            String stringOutput = formatter.format(dateInput);

            logger.info("Date stringOutput[ConverterImpl|dateToString]: {}", stringOutput);
    
            return stringOutput;
        }catch(Exception e){
            return null;
        }
    }
}
