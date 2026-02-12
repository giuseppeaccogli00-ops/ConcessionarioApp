//package org.example.repository;
//
//import org.example.models.entity.Cliente;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class ClientRepositoryTest {
//    @Autowired
//    private ClientRepository clientRepository;
//
//    @Test
//    void saveMethod(){
//        Cliente cliente = new Cliente();
//        cliente.setNome("Giuseppe");
//        cliente.setCognome("Accogli");
//        cliente.setDataNascita("04/07/00");
//
//
//        Cliente savedObject = clientRepository.save(cliente);
//        System.out.println(savedObject.getIdCliente());
//        System.out.println(savedObject.toString());
//    }
//
//    @Test
//    void updateUsingSaveMethod(){
//        int idCliente = 1;
//        Cliente Cliente = ClienteRepository.findById(idCliente).get();
//        Cliente.setModello("update modello Cliente");
//        Cliente.setCarburante("update carburante Cliente");
//        ClienteRepository.save(Cliente);
//    }
//
//    @Test
//    void findByIdMethod(){
//        int idCliente = 1;
//        Cliente Cliente = ClienteRepository.findById(idCliente).get();
//    }
//
//    @Test
//    void saveAllMethod(){
//
//        Cliente Cliente = new Cliente();
//        Cliente.setCarburante("Diesel");
//        Cliente.setPrezzo(20000);
//        Cliente.setChilometri(15000);
//        Cliente.setModello("Giulietta");
//        Cliente.setAnnoImmatricolazione(2015);
//
//        Cliente Cliente1 = new Cliente();
//        Cliente1.setCarburante("Benzina");
//        Cliente1.setPrezzo(15000);
//        Cliente1.setChilometri(100000);
//        Cliente1.setModello("Bravo");
//        Cliente1.setAnnoImmatricolazione(2010);
//
//        Cliente Cliente2 = new Cliente();
//        Cliente2.setCarburante("Benzina");
//        Cliente2.setPrezzo(5000);
//        Cliente2.setChilometri(170000);
//        Cliente2.setModello("Polo");
//        Cliente2.setAnnoImmatricolazione(2011);
//
//        ClienteRepository.saveAll(List.of(Cliente,Cliente1, Cliente2));
//    }
//
//    @Test
//    void findAllMethod(){
//        List<Cliente> Clientes = ClienteRepository.findAll();
//
//        Clientes.forEach((a)->{
//            System.out.println(a.getModello());
//        });
//    }
//
//    @Test
//    void deleteByIdMethod(){
//        int idCliente=29;
//        ClienteRepository.deleteById(idCliente);
//    }
//
//    @Test
//    void deleteMethod(){
//        int idCliente= 24;
//        Cliente Cliente = ClienteRepository.findById(idCliente).get();//identifico l'entità attraverso l'ID e mi faccio restituire l'oggetto
//        ClienteRepository.delete(Cliente);
//    }
//
//    @Test
//    void deleteAllMethod(){
////        ClienteRepository.deleteAll();
//        Cliente Cliente = ClienteRepository.findById(27).get();
//        Cliente Cliente1 = ClienteRepository.findById(28).get();
//        ClienteRepository.deleteAll(List.of(Cliente,Cliente1));
//    }
//
//    @Test
//    void countMethod(){
//        long count = ClienteRepository.count();
//        System.out.println(count);
//
//    }
//}
