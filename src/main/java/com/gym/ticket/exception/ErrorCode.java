package com.gym.ticket.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "올바르지 않은 요청입니다."),
    NOT_CORRECT_DATA(HttpStatus.BAD_REQUEST, "입력 값이 유효하지 않습니다."),
    IS_EXIST_USER(HttpStatus.BAD_REQUEST, "이미 존재하는 유저입니다.");

    private final HttpStatus status;
    private final String message;
}
