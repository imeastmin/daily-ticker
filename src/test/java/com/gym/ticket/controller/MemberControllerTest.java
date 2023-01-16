package com.gym.ticket.controller;

import com.gym.ticket.config.JpaAuditingConfig;
import com.gym.ticket.dto.MemberDto;
import com.gym.ticket.repository.MemberRepository;
import com.gym.ticket.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = MemberController.class)
@MockBean(JpaAuditingConfig.class)
public class MemberControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberRepository memberRepository;

    @Test
    @DisplayName("가입 시 올바르지 않은 형식의 이메일을 기재했을 때")
    void addMember_False_NotCollectEmailRegexp() {
    }

    @Test
    @DisplayName("가입 시 이메일 주소를 기재하지 않았을 때")
    void addMember_NullPointException_isNullEmail() {
    }

    @Test
    @DisplayName("가입 시 아이디를 기재하지 않았을 때")
    void addMember_NullPointException_isNullId() throws Exception{
        // given
        String member = objectMapper.writeValueAsString(MemberDto.builder()
                .userId(null)
                .password("password1!")
                .email("admin1!@naver.com")
                .certification(false)
                .address("경기도 광명시 안현로 15").build());

        // when
        // when & then
        mvc.perform(post("/api/v1/member")
                        .content(member)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError())
                .andDo(print());
    }

    @Test
    @DisplayName("가입 시 아이디 최소 길이를 충족하지 않았을 떄")
    void addMember_False_TooShortIdData() {
    }

    @Test
    @DisplayName("가입 시 아이디 최대 길이를 초과했을 떄")
    void addMember_False_TooLongIdData() {
    }
}
