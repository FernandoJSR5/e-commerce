package com.api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ErrorResponse extends RuntimeException {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeStamp;
    private String message;
    private  String details;

    public ErrorResponse(String message) {
        super();
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }

}
