package hello.hellospring.domain;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member memver);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
