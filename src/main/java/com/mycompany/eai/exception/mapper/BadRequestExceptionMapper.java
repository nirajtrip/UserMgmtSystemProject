package com.mycompany.eai.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mycompany.eai.exception.BadRequestException;


@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException>
{
	
	@Override
	public Response toResponse(BadRequestException exception)
	{
		return Response.status(Status.BAD_REQUEST).
				entity("Bad URL Request! Try http://<server-name>/api/v1/").
				type(MediaType.TEXT_PLAIN_TYPE).
				build();
	}
	
}
