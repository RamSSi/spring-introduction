package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        System.out.println("condition1 : result = " + (result == member));
        // Assertions.assertEquals(member, result);    // 기대값, 실제 값
        assertThat(member).isEqualTo(result);
        // member가 result와 같으면 success, 다르면 fail
        // 실무에서는 조건에 부합하지 않으면 다음 조건으로 넘어갈 수 없도록 하여 test한다.
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // Optional<Member> result = repository.findByName("spring");
        Member result = repository.findByName("spring1").get();
        // get()으로 Optional 없이 값을 얻을 수 있음

        System.out.println("condition2 : result = " + (result == member1));
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        System.out.println("condition3 : result = " + (result.size() == 2));
        assertThat(result.size()).isEqualTo(2);
    }
}

