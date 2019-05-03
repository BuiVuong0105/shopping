package vn.com.vuong.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import lombok.extern.slf4j.Slf4j;
import vn.com.vuong.constant.Constant;
import vn.com.vuong.constant.HTTPErrorCode;
import vn.com.vuong.exception.ApplicationException;
import vn.com.vuong.model.Error;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAddvice {

	@InitBinder(value = { "startDate", "endDate" })
	public void initBinder(WebDataBinder binder, HttpServletRequest request) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(Constant.FormateDate.DD_MM_YYYY), true));
	}

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<?> handleDataFail(ApplicationException ex) {
		Error error = new Error(ex.getCode(), HTTPErrorCode.getMessage(ex.getCode()));
		ex.printStackTrace();
		log.error(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandle(Exception ex) {
		Error error = new Error(HTTPErrorCode.ERROR, HTTPErrorCode.getMessage(HTTPErrorCode.ERROR));
		ex.printStackTrace();
		log.error(ex.getMessage());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
}
