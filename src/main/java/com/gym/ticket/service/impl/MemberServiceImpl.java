package com.gym.ticket.service.impl;

import com.gym.ticket.dto.MemberDto;
import com.gym.ticket.repository.MemberRepository;
import com.gym.ticket.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberDto addMember(MemberDto member) {
        return MemberDto.of(memberRepository.save(member.toEntity()));
    }
}
