package org.programers.vouchermanagement.member.application;

import org.programers.vouchermanagement.member.domain.Member;
import org.programers.vouchermanagement.member.domain.MemberRepository;
import org.programers.vouchermanagement.member.domain.MemberStatus;
import org.programers.vouchermanagement.member.dto.MemberResponse;
import org.programers.vouchermanagement.member.dto.MembersResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MembersResponse findAllByStatus(MemberStatus status) {
        List<Member> members = memberRepository.findAllByStatus(status);
        return new MembersResponse(members.stream().map(MemberResponse::new).collect(Collectors.toList()));
    }
}
