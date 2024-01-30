package spring.restdocs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.restdocs.domain.Member;
import spring.restdocs.domain.MemberRepository;
import spring.restdocs.service.dto.MemberCreateRequest;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member create(final MemberCreateRequest request) {
        Member newMember = new Member(request.name(), request.age());
        memberRepository.save(newMember);

        return newMember;
    }

    public Member findById(final Long memberId) {
        return findMemberById(memberId);
    }

    private Member findMemberById(final Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Long deleteById(final Long memberId) {
        Member member = findMemberById(memberId);
        memberRepository.deleteById(member.getId());

        return memberId;
    }
}
