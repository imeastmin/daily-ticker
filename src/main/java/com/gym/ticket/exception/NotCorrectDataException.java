package com.gym.ticket.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.ValidationException;

@Getter
@AllArgsConstructor
public class NotCorrectDataException extends ValidationException {

    private final int code;
    private final String message;

}
