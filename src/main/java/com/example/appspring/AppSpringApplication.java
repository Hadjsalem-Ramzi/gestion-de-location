package com.example.appspring;

import com.example.appspring.Entity.Voiture;
import com.example.appspring.repository.VoitureRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class AppSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(AppSpringApplication.class, args);
//        VoitureRepository voitureDao =ctx.getBean(VoitureRepository.class);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            Date date1 = dateFormat.parse("2000-05-30");
//            Date date2 = dateFormat.parse("2000-06-15");
//
//            voitureDao.save(new Voiture(70, date1));
//            voitureDao.save(new Voiture(80, date2));
//
//            System.out.println("Voiture enregistrée avec la date : " + dateFormat.format(date1));
//            System.out.println("Voiture enregistrée avec la date : " + dateFormat.format(date2));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
    }

}
