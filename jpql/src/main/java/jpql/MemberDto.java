package jpql;

public class MemberDto {

    private String usernmae;

    private int age;

    public MemberDto(String usernmae, int age) {
        this.usernmae = usernmae;
        this.age = age;
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
