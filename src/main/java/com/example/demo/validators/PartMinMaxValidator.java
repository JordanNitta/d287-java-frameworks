package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PartMinMaxValidator implements ConstraintValidator<ValidPartMinMaxValidator, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidPartMinMaxValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        if (part.getInv() >= part.getMinInv() && part.getInv() <= part.getMaxInv()) {
//            System.out.println("Between Min and Max");
//            System.out.println(part.getMinInv() + " " + part.getMaxInv());
            return true;
        }

        else{
            if(part.getInv() < part.getMinInv()){
                constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory is below the minimum value").addConstraintViolation();
//                System.out.println("B-----------");
            }
            if(part.getInv() > part.getMaxInv()){
                constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory is greater than maximum value").addConstraintViolation();
//                System.out.println("----------aaaa");
            }
            return false;
        }

    }
}
