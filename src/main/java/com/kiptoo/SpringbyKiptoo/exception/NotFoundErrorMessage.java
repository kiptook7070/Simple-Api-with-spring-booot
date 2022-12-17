package com.kiptoo.SpringbyKiptoo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
