package spring.restdocs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.restdocs.controller.dto.MemberCreateResponse;
import spring.restdocs.controller.dto.MemberFindResponse;
import spring.restdocs.domain.Member;
import spring.restdocs.service.MemberService;
import spring.restdocs.service.dto.MemberCreateRequest;
import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberCreateResponse> createMember(@RequestBody final MemberCreateRequest request) {
        Member newMember = memberService.create(request);
        MemberCreateResponse response = new MemberCreateResponse(newMember.getId(), newMember.getName(), newMember.getAge());

        URI uri = URI.create("/members" + response.id());
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberFindResponse> findMember(@PathVariable(name = "id") final Long id) {
        Member findMember = memberService.findById(id);
        MemberFindResponse response = new MemberFindResponse(findMember.getId(), findMember.getName(), findMember.getAge());

        return ResponseEntity.ok()
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable(name = "id") final Long id) {
        memberService.deleteById(id);

        return ResponseEntity.noContent()
                .build();
    }
}
