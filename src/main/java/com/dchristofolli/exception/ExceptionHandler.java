package com.dchristofolli.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<ApiException> {
    @Override
    public Response toResponse(ApiException apiException) {
        return Response.status(Response.Status.BAD_REQUEST).entity(apiException.getMessage()).build();
    }
}
