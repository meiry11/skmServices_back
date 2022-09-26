package com.skmServices.skmServices.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.skmServices.skmServices.repository.IClientRepo;


public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);


//    @Bean
//    CommandLineRunner initDatabase(IClientRepo clientRepo) {
//        return args -> {
////            log.info("loading data " + clientRepo.save(new Client(
////                    "nom",  "prenom", "nom.prenom@test.fr", "0752060066",  Date.valueOf("1978-09-16"), 1,  "motDePasse"
////            )));
//            //log.info("***********************loading data ");
//            System.out.println("test");
//        };
//    }
//
//    CommandLineRunner initDatabase(IAdresseRepo adresseRepo) {
//        return args -> {
//            log.info("loading data " + adresseRepo.save(new Adresse("rue",1,"59150","wattrelos", new Client(
//                    "nom",  "prenom", "nom.prenom@test.fr", "0752060066", Date dateCreation, Integer numeroSiret,  "motDePasse", List<Adresse> adresse, List< Commande > commande, Role role
//            ))));
//
//            };
//    }
}
