package com.gym.ticket.payload;

import com.gym.ticket.exception.CustomErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final int error;
    private final String message;

    public static <T> ErrorResponse error(CustomErrorCode code, String message) {
        return new ErrorResponse(code.getStatus().value(), message);
    }
}
