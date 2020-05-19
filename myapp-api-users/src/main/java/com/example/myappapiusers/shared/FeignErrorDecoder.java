package com.example.myappapiusers.shared;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


@Component
@RefreshScope
public class FeignErrorDecoder implements ErrorDecoder {
    @Value("${albums.exception.albums-not-found}")
    String errorMessage;

//    Environment env; // albums.exception.albums-not-found
//
//    @Autowired
//    public FeignErrorDecoder(Environment env){
//        this.env =env;
//    }

    @Override
    public Exception decode(String methodkey, Response response) {
        switch (response.status()){
            case 400:
                break;
            case 404:
                if(methodkey.contains("getAlbums")){
                    return new ResponseStatusException(
                            HttpStatus.valueOf(response.status()),
                            errorMessage
                    );
                }
                break;
            default:
                return new Exception(response.reason());
        }
        return null;
    }
}