package com.crudoperation.Crud;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ExceptionThrower {
    LocalDateTime time;
    String message;

    public ExceptionThrower(LocalDateTime time, String message) {
        this.time = time;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
