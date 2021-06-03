package jpql;



import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hello");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            manager.persist(member);

            TypedQuery<Member> query1 = manager.createQuery("select m from Member m", Member.class);
            // 객체 자체를 가져와서 객체타입(주로 엔티티)로 받음
            String singleResult2 = manager.createQuery("select m.username from Member m where m.username = :username", String.class)
                    .setParameter("username", "member1").getSingleResult();
            // 객체의 문자열 필드를 가져옴
            Query query3 = manager.createQuery("select m.username,m.age from Member m");
            // 반환 타입이 불명확 할때는 Query 사용

            Member singleResult1 = query1.getSingleResult();
            System.out.println("singleResult2 = " + singleResult2);



            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            manager.close();
        }

        factory.close();
    }
}
