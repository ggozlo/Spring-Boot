package jpa.jpabook;

import jpa.jpabook.domain.Book;
import jpa.jpabook.domain.Member;
import jpa.jpabook.domain.Order;
import jpa.jpabook.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hello");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        try {

            Book book = new Book();

            book.setName("JPA");
            book.setAuthor("김영한");

            manager.persist(book);

            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            manager.close();
        }
        factory.close();

    }
}
