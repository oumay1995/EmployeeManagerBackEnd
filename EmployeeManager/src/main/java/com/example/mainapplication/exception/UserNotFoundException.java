package com.example.mainapplication.exception;

public class UserNotFoundException extends RuntimeException{
	 public UserNotFoundException(String messages) {
		 super(messages);
	 }

}
