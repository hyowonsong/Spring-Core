package hello.core.member;

//인스턴스 변수들은 클래스 외부에서 직접 접근을 제한하기 위해 private 으로 선언되었지만,
//생성자는 다른 클래스에서 Member 클래스의 인스턴스를 생성하고 초기값을 설정할 수 있도록 public 으로 정의
public class Member {

    private Long id;
    private String name;
    private Grade grade;

    //  Member 객체를 생성할 때 id, name 및 grade 값을 제공하여 해당 Member 객체를 초기화 가능
    public Member (Long id, String name, Grade grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }


}
