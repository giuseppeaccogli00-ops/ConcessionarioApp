//package org.example.repository;
//
//import org.example.models.entity.Auto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class VenditoreRepositoryTest {
//    @Autowired
//    private AutoRepository autoRepository;
//
//    @Test
//    void saveMethod(){
//        Auto auto = new Auto();
//        auto.setCarburante("Diesel");
//        auto.setPrezzo(20000);
//        auto.setChilometri(15000);
//        auto.setModello("Giulietta");
//        auto.setAnnoImmatricolazione(2015);
//
//        Auto savedObject = autoRepository.save(auto);
//        System.out.println(savedObject.getIdAuto());
//        System.out.println(savedObject.toString());
//    }
//
//    @Test
//    void updateUsingSaveMethod(){
//        int idAuto = 1;
//        Auto auto = autoRepository.findById(idAuto).get();
//        auto.setModello("update modello auto");
//        auto.setCarburante("update carburante auto");
//        autoRepository.save(auto);
//    }
//
//    @Test
//    void findByIdMethod(){
//        int idAuto = 1;
//        Auto auto = autoRepository.findById(idAuto).get();
//    }
//
//    @Test
//    void saveAllMethod(){
//
//        Auto auto = new Auto();
//        auto.setCarburante("Diesel");
//        auto.setPrezzo(20000);
//        auto.setChilometri(15000);
//        auto.setModello("Giulietta");
//        auto.setAnnoImmatricolazione(2015);
//
//        Auto auto1 = new Auto();
//        auto1.setCarburante("Benzina");
//        auto1.setPrezzo(15000);
//        auto1.setChilometri(100000);
//        auto1.setModello("Bravo");
//        auto1.setAnnoImmatricolazione(2010);
//
//        Auto auto2 = new Auto();
//        auto2.setCarburante("Benzina");
//        auto2.setPrezzo(5000);
//        auto2.setChilometri(170000);
//        auto2.setModello("Polo");
//        auto2.setAnnoImmatricolazione(2011);
//
//        autoRepository.saveAll(List.of(auto,auto1, auto2));
//    }
//
//    @Test
//    void findAllMethod(){
//        List<Auto> autos = autoRepository.findAll();
//
//        autos.forEach((a)->{
//            System.out.println(a.getModello());
//        });
//    }
//
//    @Test
//    void deleteByIdMethod(){
//        int idAuto=29;
//        autoRepository.deleteById(idAuto);
//    }
//
//    @Test
//    void deleteMethod(){
//        int idAuto= 24;
//        Auto auto = autoRepository.findById(idAuto).get();//identifico l'entità attraverso l'ID e mi faccio restituire l'oggetto
//        autoRepository.delete(auto);
//    }
//
//    @Test
//    void deleteAllMethod(){
////        autoRepository.deleteAll();
//        Auto auto = autoRepository.findById(27).get();
//        Auto auto1 = autoRepository.findById(28).get();
//        autoRepository.deleteAll(List.of(auto,auto1));
//    }
//
//    @Test
//    void countMethod(){
//        long count = autoRepository.count();
//        System.out.println(count);
//
//    }
//}
