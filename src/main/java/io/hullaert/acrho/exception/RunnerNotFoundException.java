package io.hullaert.acrho.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // 404
public class RunnerNotFoundException extends RuntimeException{
    public RunnerNotFoundException(long runnerId){
        super("Runner " + runnerId + " does not exist.");
    }
}
