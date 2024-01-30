package spring.restdocs.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.restdocs.domain.Member;
import spring.restdocs.domain.MemberRepository;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class JpaMemberRepositoryImpl implements MemberRepository {

    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;

    @Override
    public Long save(final Member member) {
        Member savedMember = springDataJpaMemberRepository.save(member);
        return savedMember.getId();
    }

    @Override
    public Optional<Member> findById(final Long memberId) {
        return springDataJpaMemberRepository.findById(memberId);
    }

    @Override
    public void deleteById(final Long memberId) {
        springDataJpaMemberRepository.deleteById(memberId);
    }
}
