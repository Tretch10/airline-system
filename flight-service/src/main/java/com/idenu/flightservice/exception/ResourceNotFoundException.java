package com.idenu.flightservice.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public String id;

    public ResourceNotFoundException(String id) {
        super(String.format("Flight with id: %s not found", id));
        this.id = id;
    }
}
