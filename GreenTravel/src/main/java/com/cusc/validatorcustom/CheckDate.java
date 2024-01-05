/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.validatorcustom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;

import javax.validation.Payload;

/**
 *
 * @author kyqua
 */
@Documented
@Constraint(validatedBy = CheckDateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckDate {

    String message() default "Date must 18 ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
