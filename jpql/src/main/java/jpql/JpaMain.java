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

            Team team =new Team();
            team.setName("Team1");
            manager.persist(team);

            Team team2 =new Team();
            team2.setName("Team2");
            manager.persist(team2);

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.setType(MemberType.ADMIN);
            member.changeTeam(team);

            manager.persist(member);


            Member member1 = new Member();
            member1.setUsername("member2");
            member1.changeTeam(team);
            manager.persist(member1);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.changeTeam(team2);
            manager.persist(member3);



//            for (int i = 0; i < 10; i++) {
//                Member member = new Member();
//                member.setUsername("member"+i);
//                member.setAge(i);
//                manager.persist(member);
//
//                Team team = new Team();
//                team.setName("team"+i);
//                member.setTeam(team);
//                manager.persist(team);
//            }

//            TypedQuery<Member> query1 = manager.createQuery("select m from Member m", Member.class);
            // 객체 자체를 가져와서 객체타입(주로 엔티티)로 받음
//            String singleResult2 = manager.createQuery("select m.username from Member m where m.username = :username", String.class)
//                    .setParameter("username", "member1").getSingleResult();
            // 객체의 문자열 필드를 가져옴
 //           Query query3 = manager.createQuery("select m.username,m.age from Member m");
            // 반환 타입이 불명확 할때는 Query 사용

            manager.flush();
            manager.clear();


            // 컬렉션으로 받아온 엔티티 모두가 영속상태이다.

//            Object o = result.get(0);
//            Object[] objects = (Object[]) o;

            // 쿼리타입의 값 가져오기 1 , 배열 순서는 데이터베이스에서 가져온 인덱스 순서로 오브젝트 배열이 된다

//            List<Object[]> result = manager.createQuery("select distinct m.username, m.age from Member m ").getResultList();
            // 쿼리타입 값 가져오기 2 , 가져올때 부터 오브젝트 배열의 리스트로 가져온다

//            Object[] objects = result.get(0);
//            System.out.println("objects[0] = " + objects[0]);
//            System.out.println("objects[1] = " + objects[1]);

//            List<MemberDto> resultList = manager.createQuery("select new jpql.MemberDto(m.username, m.age) from Member m ", MemberDto.class).getResultList();
            // 쿼리타입 값 가져오기 3, 가져올떄에 출력값 순서와 일치하는 DTO 생성자로 바로 만들기 , 패키지명 포함 전체 클래스 명




//            List<Member> resultList = manager.createQuery("select m from Member m order by m.age desc ", Member.class)
//                    .setFirstResult(1).setMaxResults(10).getResultList();
            // 페이징 처리 , 유용하다!

//            String jpql = "select m from Member m  join Team t on m.username = t.name";
            //  내부조인, 외부조인, 카테이션곱, join ~ on 절 모두 구현 가능!

//            String jpql = "select (select avg (m1.age) from Member m1) as ageAvg from Member m join m.team";
//            List<Double> result = manager.createQuery(jpql, Double.class).getResultList();
            // 서브쿼리 where, having, select 절에서 가능, from절 은 불가

//            String jpql = "select m.username , 'string', TRUE  FROM Member m where m.type = :userType";
//            List<Object[]> result = manager.createQuery(jpql).setParameter("userType", MemberType.ADMIN).getResultList();
            // enum 타입을 쓸때는 enum 클래스의 경로까지 전부 써야함 또는 동적 파라메터 적용
            // sql 에서 쓰이는 각종 표현법, 기타식 전부 사용가능

//            String jpql = "select " +
//                    "case when m.age <= 10 then '학생요금'" +
//                    "     when m.age >= 60 then '일반요금'" +
//                    "     else '일반요금'" +
//                    "end " +
//                    "from  Member m";
//            List<String> resultList = manager.createQuery(jpql, String.class).getResultList();
            // case 문 , 단순 case도 가능

//            String jpql = "select coalesce(m.username, '이름 없는 회원') as username from Member m";
//            List<String> resultList = manager.createQuery(jpql, String.class).getResultList();
            // null 이면 정해진 값을 반환

//            String jpql = "select nullif(m.username, 'member1') as username from Member m";
//            List<String> resultList = manager.createQuery(jpql, String.class).getResultList();
            // 변수가 정해진 값과 같다면 null을 반환시킴 (탈락시킨다)

//            String jpql = "select group_concat(m.username) from  Member m";
//            List<String> resultList = manager.createQuery(jpql, String.class).getResultList();
            // 직접 dialect 클래스를 생성, 기존걸 상속받아 추가할수 있다.
            // 그 클래스를 dialect 옵션으로 지정해주면 사용가능
            // 기본 함수들은 기본 함수다 size 정도가 연관관계 매핑에서 fk수를 세어준다
            // 기능은 이름 작명을 따라가는듯

            // 페치조인은 가져올때 연관관계 테이블을 한 쿼리문에 묶어서 가져옴

            //String query = "select m from Member m where m.team = :team";
            // jpa는 조회시 엔티티 자체로 조회할수 있고 pk로 치환된다

 //           List<Member> result = manager.createNamedQuery("Member.findByUsername", Member.class).setParameter("username", "member1").getResultList();
            //네임드 쿼리

            int count = manager.createQuery("update Member m set m.age = 10").executeUpdate();
            // flush 자동 호출, 영속성 컨텍스틑 거치지 않기떄문에 값이 꼬일수 있으니 가장 먼저 사용후 컨텍스트 초기화 추천

            System.out.println("count = " + count);

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
