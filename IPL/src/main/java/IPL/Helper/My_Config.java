package IPL.Helper;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.ComponentScan;

@Configuration //here by using this annotation we will do the configuration of our project.
//@ComponentScan("IPL.Controller") 
//@ComponentScan("IPL.Dao") 
//@ComponentScan("IPL.Dto") 
//@ComponentScan("IPL.Helper")

@ComponentScan("IPL")  //here all the basepackages are presented internally
public class My_Config 
{

	@Bean  //it will help to create reference variable of interface type
	public EntityManagerFactory getEntityManagerFactory() 
	{
       EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	   return entityManagerFactory;
	}

}

