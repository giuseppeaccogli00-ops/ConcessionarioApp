//package org.example.repository;
//
//import org.example.models.entity.AcquistoFornitore;
//import org.example.models.entity.AcquistoFornitore;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class AcquistoFornitoreRepositoryTest {
//    @Autowired
//    private AcquistoFornitoreRepository acquistoFornitoreRepository;
//
//    @Test
//    void saveMethod(){
//        AcquistoFornitore acquistoFornitore = new AcquistoFornitore();
//        acquistoFornitore.setIdFornitore(2);
//        acquistoFornitore.setIdAuto(3);
//        acquistoFornitore.setDataAcquistoFornitore("03/02/2026");
//        acquistoFornitore.setCostoAcquistoFornitore(15000);
//
//
//        AcquistoFornitore savedObject = acquistoFornitoreRepository.save(acquistoFornitore);
//        System.out.println(savedObject.getIdFornitore());
//        System.out.println(savedObject.toString());
//    }
//
//    @Test
//    void updateUsingSaveMethod(){
//        int idAcquistoFornitore = 1;
//        AcquistoFornitore acquistoFornitore = acquistoFornitoreRepository.findById(idAcquistoFornitore).get();
//        acquistoFornitore.setDataAcquistoFornitore("update date");
//        acquistoFornitoreRepository.save(acquistoFornitore);
//    }
//
//    @Test
//    void findByIdMethod(){
//        int idAcquistoFornitore = 1;
//        AcquistoFornitore acquistoFornitore = acquistoFornitoreRepository.findById(idAcquistoFornitore).get();
//    }
//
//    @Test
//    void saveAllMethod(){
//
//        AcquistoFornitore acquistoFornitore1 = new AcquistoFornitore();
//        acquistoFornitore1.setIdFornitore(2);
//        acquistoFornitore1.setIdAuto(3);
//        acquistoFornitore1.setDataAcquistoFornitore("03/02/2026");
//        acquistoFornitore1.setCostoAcquistoFornitore(15000);
//
//        AcquistoFornitore acquistoFornitore2 = new AcquistoFornitore();
//        acquistoFornitore2.setIdFornitore(3);
//        acquistoFornitore2.setIdAuto(4);
//        acquistoFornitore2.setDataAcquistoFornitore("03/01/2026");
//        acquistoFornitore2.setCostoAcquistoFornitore(16000);
//
//        AcquistoFornitore acquistoFornitore3 = new AcquistoFornitore();
//        acquistoFornitore3.setIdFornitore(5);
//        acquistoFornitore3.setIdAuto(6);
//        acquistoFornitore3.setDataAcquistoFornitore("03/02/2025");
//        acquistoFornitore3.setCostoAcquistoFornitore(17000);
//
//        acquistoFornitoreRepository.saveAll(List.of(acquistoFornitore1,acquistoFornitore2, acquistoFornitore3));
//    }
//
//    @Test
//    void findAllMethod(){
//        List<AcquistoFornitore> AcquistoFornitores = acquistoFornitoreRepository.findAll();
//
//        AcquistoFornitores.forEach((a)->{
//            System.out.println(a.getDataAcquistoFornitore());
//        });
//    }
//
//    @Test
//    void deleteByIdMethod(){
//        int idAcquistoFornitore=29;
//        acquistoFornitoreRepository.deleteById(idAcquistoFornitore);
//    }
//
//    @Test
//    void deleteMethod(){
//        int idAcquistoFornitore= 24;
//        AcquistoFornitore acquistoFornitore = acquistoFornitoreRepository.findById(idAcquistoFornitore).get();//identifico l'entità attraverso l'ID e mi faccio restituire l'oggetto
//        acquistoFornitoreRepository.delete(acquistoFornitore);
//    }
//
//    @Test
//    void deleteAllMethod(){
////        acquistoFornitoreRepository.deleteAll();
//        AcquistoFornitore acquistoFornitore = acquistoFornitoreRepository.findById(27).get();
//        AcquistoFornitore acquistoFornitore1 = acquistoFornitoreRepository.findById(28).get();
//        acquistoFornitoreRepository.deleteAll(List.of(acquistoFornitore,acquistoFornitore1));
//    }
//
//    @Test
//    void countMethod(){
//        long count = acquistoFornitoreRepository.count();
//        System.out.println(count);
//
//    }
//}
