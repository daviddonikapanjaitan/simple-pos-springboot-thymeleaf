package com.simple.pos.simplepointofsale.utils;

import java.util.Date;

public interface ConverterService {

    String dateToString(Date dateInput, String format);
    Date stringToDate(String stringInput, String format);
}
