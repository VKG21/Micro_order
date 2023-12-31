package com.user.UserService.exception.handler;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	long fieldValue;
	String fieldStringValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public ResourceNotFoundException(String resourceName, String fieldName, String fieldStringValue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldStringValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldStringValue = fieldStringValue;
	}
	
	
	

}