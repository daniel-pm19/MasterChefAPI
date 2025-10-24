package com.dosw.MasterChefAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    
    public static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }

    public static ResourceNotFoundException create(String resourceType, Object resourceId){
        return new ResourceNotFoundException(String.format("%s with ID '%s' not found", resourceType, resourceId));
    }
}
