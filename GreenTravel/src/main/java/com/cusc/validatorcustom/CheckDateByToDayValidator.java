/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.validatorcustom;

import java.sql.Date;
import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author kyqua
 */
public class CheckDateByToDayValidator implements ConstraintValidator<CheckDateByToDay, Date> {

    @Override
    public void initialize(CheckDateByToDay constraintAnnotation) {

    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        LocalDate localDate = LocalDate.now();
        Date toDay = Date.valueOf(localDate);
        return value.after(toDay);
    }

}
