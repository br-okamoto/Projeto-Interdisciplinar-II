package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Produto;

public class TestaInsereProduto {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lojavirtualDB");
        EntityManager em = factory.createEntityManager();
        Produto p = new Produto();
        p.setNome("Tenis Nike");
        p.setPreco(222.90);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
}
/*
 Script do Mysql
 create database lojavirtualDB;
 use lojavirtualDB;
 CREATE  TABLE `lojavirtualdb`.`Produto` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NULL ,
  `preco` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) );
 */