package com.tg.restdemo.exceptionhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.tg.restdemo.model.ErrorMsg;

/**
 * 
 * Exception Class Mapper handling 'Data Not Found' exception
 *
 */

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMsg errorMessage = new ErrorMsg(ex.getMessage(), 404, "http://purchaseOrders");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
