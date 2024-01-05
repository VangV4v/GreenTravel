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
class CheckDateValidator implements ConstraintValidator<CheckDate, Date> {

    @Override
    public void initialize(CheckDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        LocalDate date = LocalDate.from(value.toLocalDate());
        int checkAge = LocalDate.now().getYear() - date.getYear();
        System.out.println("------" + checkAge);
        return checkAge > 18 ? true : false;
    }

}
