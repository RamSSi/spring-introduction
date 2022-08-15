package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public interface MemberRepository {
    Member save(Member member); // 회원 저장
    // Optional : method의 반환값이 null일 경우 처리하는 방법 중 하나
    Optional<Member> findById(Long id); // repo에 저장된 회원을 id로 검색
    Optional<Member> findByName(String name);   // repo에 저장된 회원을 name으로 검색
    List<Member> findAll(); // 모든 회원 검색
}
