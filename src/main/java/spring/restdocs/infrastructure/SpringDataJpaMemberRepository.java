package spring.restdocs.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.restdocs.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {
}
