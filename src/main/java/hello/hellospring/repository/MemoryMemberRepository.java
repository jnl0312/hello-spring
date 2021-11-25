package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemberRepository;

import java.util.HashMap;
import java.util.List;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        // id값이 null일 때 처리해주는 방법 : Optional
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<Member> findAll() {
        // store의 모든 member를 List형태로 반환한다.
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    public void clearStore() {
        store.clear();
    }

}
