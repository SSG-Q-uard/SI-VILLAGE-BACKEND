package org.example.sivillage.member.infrastructure;

import org.example.sivillage.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Boolean existsByEmail(String email);

    Optional<Member> findByMemberUuid(String memberUuid);
}
