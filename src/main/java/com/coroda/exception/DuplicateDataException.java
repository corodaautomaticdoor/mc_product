package com.coroda.exception;

public class DuplicateDataException extends Exception{

	private static final long serialVersionUID = 1L;

public DuplicateDataException() {
		super();
		
	}


@Override
public String getMessage() {
    return "los datos ingresados ya se encuentran registrados dentro de la base de datos";
}
}
