package com.gym.ticket.service.impl;

import com.gym.ticket.dto.MemberDto;
import com.gym.ticket.entity.Member;
import com.gym.ticket.repository.MemberRepository;
import com.gym.ticket.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberDto addMember(MemberDto member) {
        return MemberDto.of(memberRepository.save(Member.builder()
                .userId(member.getUserId())
                .password(member.getPassword())
                .email(member.getEmail())
                .certification(member.getCertification())
                .address(member.getAddress())
                .build()));
    }
}
