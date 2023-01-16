package com.gym.ticket.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DailyTicketException extends RuntimeException{

    private final ErrorCode errorCode;
    private String message;

    public DailyTicketException(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.errorCode = errorCode;
    }
}
