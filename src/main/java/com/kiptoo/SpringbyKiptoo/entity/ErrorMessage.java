package com.kiptoo.SpringbyKiptoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
//Using Lombok to annotate data for getters and setters

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatus httpStatus;
    private  String message;
}
