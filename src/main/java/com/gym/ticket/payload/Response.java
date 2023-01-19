package com.gym.ticket.payload;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class Response<T> {

    @ApiModelProperty(example = "상태코드")
    private final int code;

    @ApiModelProperty(example = "상태값")
    private final String message;

    @ApiModelProperty(example = "전송값")
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<T>(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase(), data);
    }


}
