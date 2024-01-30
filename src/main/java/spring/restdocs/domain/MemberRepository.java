package spring.restdocs.domain;

import java.util.Optional;

public interface MemberRepository {

    Long save(final Member member);

    Optional<Member> findById(final Long memberId);

    void deleteById(final Long memberId);
}
