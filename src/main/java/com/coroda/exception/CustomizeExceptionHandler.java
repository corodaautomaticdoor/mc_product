package com.coroda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@ControllerAdvice
public class CustomizeExceptionHandler {


	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomizeErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exc, WebRequest req) {
		
		CustomizeErrorDetails resourceNotFound = new CustomizeErrorDetails(new Date(), exc.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeErrorDetails>(resourceNotFound, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataException.class)
	public ResponseEntity<CustomizeErrorDetails> handlDataFormatException(DataException exc, WebRequest req){
		
		CustomizeErrorDetails dataErrorDetail = new CustomizeErrorDetails(new Date(), exc.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<CustomizeErrorDetails> (dataErrorDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<AttributeValidation> methodArgumentNotValidException(HttpServletRequest request,
			MethodArgumentNotValidException e) {

		// traes los errores
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		// conviertes los errrores a un estado estandar
		StringBuilder errorMessage = new StringBuilder();
		fieldErrors.forEach(f -> errorMessage.append(f.getField() + " " + f.getDefaultMessage() + " "));

		// retornas tu objeto de error con un estandar json
		AttributeValidation attributeValidation = new AttributeValidation(HttpStatus.BAD_REQUEST.value(), errorMessage.toString(),
				request.getRequestURI());
		return new ResponseEntity<>(attributeValidation, HttpStatus.BAD_REQUEST);

	}
}