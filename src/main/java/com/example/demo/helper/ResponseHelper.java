package com.example.demo.helper;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {

    /**
     * 
     * @param message
     * @param status
     * @param responseObj
     * @return
     */
    public static ResponseEntity<Object> getResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("message", message != null ? message : status.getReasonPhrase());
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, status);
    }


    /**
     * It returns a response entity object with a map containing a message, status, and data
     * 
     * @param responseObj The object that you want to return to the client.
     * @return A ResponseEntity object with a map of the response object, a message, and a status.
     */
    public static ResponseEntity<Object> getResponseSuccess(Object responseObj, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message != null ? message : HttpStatus.OK.getReasonPhrase());
        map.put("status",  HttpStatus.OK.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    /**
     * It returns a response with no content.
     * 
     * @return A ResponseEntity object with a map of the message, status, and data.
     */
    public static ResponseEntity<Object> getResponseNoContent() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", HttpStatus.NO_CONTENT.getReasonPhrase());
        map.put("status",  HttpStatus.NO_CONTENT.value());
        map.put("data", null);

        return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
    }

    /**
     * It returns a response with status code 500 and a message.
     * 
     * @return A ResponseEntity object.
     */
    public static ResponseEntity<Object> getResponseInternalServerError() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        map.put("status",  HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("data", null);

        return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}