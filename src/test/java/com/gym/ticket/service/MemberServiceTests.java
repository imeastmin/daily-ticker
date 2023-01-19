package com.gym.ticket.service;

import com.gym.ticket.dto.MemberDto;
import com.gym.ticket.repository.MemberRepository;
import com.gym.ticket.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(MockitoExtension.class)
public class MemberServiceTests {

    @Mock
    MemberRepository memberRepository;
    @InjectMocks
    MemberServiceImpl memberService;

    @Test
    @DisplayName("회원가입 테스트 - UserId 값으로 Null Data가 들어왔을 경우")
    @Transactional
    void addMember_InsertNullUserId_False() throws Exception {
    }
}
