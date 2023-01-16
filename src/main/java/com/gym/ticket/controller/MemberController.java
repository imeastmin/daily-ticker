package com.gym.ticket.controller;

import com.gym.ticket.dto.MemberDto;
import com.gym.ticket.payload.Response;
import com.gym.ticket.service.MemberService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Member", description = "회원 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/member")
    @ApiOperation(
            tags = "Member",
            value = "회원가입 API",
            notes = "ID, Password, Email, Certification, Address 데이터를 입력받아 회원가입 로직을 수행함."
    )
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created Success"),
            @ApiResponse(code= 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response> addMember(@RequestBody MemberDto member) {

        MemberDto result = memberService.addMember(member);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(Response.success(result));
    }
}
