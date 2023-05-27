package kr.ac.hansung.controller;

import kr.ac.hansung.exception.OfferNotFoundException;
import kr.ac.hansung.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice //@RestControllerAdvice
public class GlobalExceptionController {
    //예외처리 핸들러
    @ExceptionHandler(OfferNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOfferNotFoundException(HttpServletRequest req, OfferNotFoundException ex){

        String requestURI = req.getRequestURI();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setRequestURI(requestURI);
        errorResponse.setErrorCode("offer.notfound.exception");
        errorResponse.setErrorMsg("Offer with id " + ex.getOfferId()+ " not found");

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
