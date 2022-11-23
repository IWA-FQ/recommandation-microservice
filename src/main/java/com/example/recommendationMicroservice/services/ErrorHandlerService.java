package com.example.recommendationMicroservice.services;

import org.springframework.data.spel.spi.Function;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ErrorHandlerService<T> {

    public ResponseEntity<T> getResponse(Optional res) {
        if(res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else if (res.isPresent()) {
            T t = (T) res.get();
            return new ResponseEntity<>(t,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<T>> getAllResponse(List<T> res) {
        if(res.size()==0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    public ResponseEntity delete(Void res) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
