package com.codewithme.jobapp.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatusCode status;
    private String message;
}
