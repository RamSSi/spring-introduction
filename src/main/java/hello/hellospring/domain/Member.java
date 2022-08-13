package hello.hellospring.domain;

public class Member {

    private Long id;    // system이 회원을 구분하기 위해 부여하는 식별자 id
    private String name;

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

}
