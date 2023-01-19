package com.gym.ticket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gym.ticket.dto.MemberDto;
import com.gym.ticket.service.impl.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.Validation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@WebMvcTest(controllers = MemberController.class)
@MockBean(Validation.class)
public class MemberControllerTests {

    @Autowired
    MockMvc mvc;

    @MockBean
    MemberServiceImpl memberService;

    private MemberDto member;

    @BeforeEach
    void init() {
        log.info("member status - {}", member);

        /* given */
        member = MemberDto.builder()
                        .userId("admin1")
                        .password("password1!")
                        .email("admin1@naver.com")
                        .certification(true)
                        .address("경기도 성남시 판교동 15번지").build();
    }

    @AfterEach
    void clear() {
        member = null;
    }

    @DisplayName("회원가입 - 정상적인 Request")
    @Test
    void addMember_Done_Success() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

        /* when & then */
        mvc.perform(post("/api/v1/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(member)))

                .andExpect(status().isCreated())
                .andDo(print());
    }
}
