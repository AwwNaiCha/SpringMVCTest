package com.sjsu.cmpe275.lab2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by huimin on 3/28/16.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExcp extends RuntimeException{
    public NotFoundExcp (String id) {
        super(id);
    }
}
