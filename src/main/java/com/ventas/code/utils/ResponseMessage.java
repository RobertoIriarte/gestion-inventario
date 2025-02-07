package com.ventas.code.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage {

    private Integer code;
    private Object data;

    public ResponseMessage(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

}
