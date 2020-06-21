package com.lab1.validators;

import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WeakPasswordClass implements ConstraintValidator<Weakpassword, String> {

   @SneakyThrows
   public boolean isValid(String obj, ConstraintValidatorContext context)
   {
      File f = new File("C:\\Users\\msi\\IdeaProjects\\lab1\\src\\main\\java\\com\\lab1\\validators\\pass.txt");
      FileReader fr=new FileReader(f);
      BufferedReader br=new BufferedReader(fr);
      StringBuffer sb=new StringBuffer();
      String line;
      while((line=br.readLine())!=null)
      {
         if(line.equals(obj)) return false;
      }
      fr.close();
      return true;
   }
}
