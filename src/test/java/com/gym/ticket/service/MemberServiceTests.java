package com.gym.ticket.service;

import com.gym.ticket.dto.MemberDto;
import com.gym.ticket.entity.Member;
import com.gym.ticket.repository.MemberRepository;
import com.gym.ticket.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.transaction.Transactional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTests {

    @Mock
    MemberRepository memberRepository;
    @InjectMocks
    MemberServiceImpl memberService;

    private MemberDto data;

    @Test
    @DisplayName("회원가입 테스트 - UserId 값으로 Null Data가 들어왔을 경우")
    @Transactional
    void addMember_InsertNullUserId_False() throws Exception {
        /* given */
        Member data = Member.builder()
                .userId(null)
                .password("password1!")
                .email("test@gmail.com")
                .certification(true)
                .address("경기도 성남시 판교동 15번지").build();

        /* when */
        when(memberRepository.save(data)).thenReturn(null);
        MemberDto result = memberService.addMember();

        /* then*/
        Assertions.assertEquals(null, result);

    }
}
