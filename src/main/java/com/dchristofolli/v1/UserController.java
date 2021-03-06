package com.dchristofolli.v1;

import com.dchristofolli.exception.ApiException;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    UserService userService;

    @POST
    @Operation(description = "Allows to create a new user")
    @APIResponse(responseCode = "201", description = "User created")
    @APIResponse(responseCode = "400", description = "Bad request")
    @APIResponse(responseCode = "500", description = "Internal error")
    public Response create(@Valid @RequestBody UserDto user) {
        userService.create(user);
        return Response.status(201).build();
    }

    @GET
    @Operation(description = "Returns a user data by id, username or cpf or displays all users " +
        "if the request is made without parameter")
    @APIResponse(responseCode = "200", description = "User displayed")
    @APIResponse(responseCode = "500", description = "Internal error")
    @Path("{param}")
    public List<UserDto> find(@QueryParam String param) throws ApiException {
        return userService.find(param);
    }

    @PATCH
    @Operation(description = "Allows to update a username")
    @APIResponse(responseCode = "200", description = "Username updated")
    @APIResponse(responseCode = "400", description = "Bad request")
    @APIResponse(responseCode = "500", description = "Internal error")
    @Path("{cpf}/{newName}")
    public UserDto updateUsername(@PathParam String cpf, @PathParam String newName) {
        return userService.updateUsername(cpf, newName);
    }

    @DELETE
    @Operation(description = "Allows to delete a user")
    @APIResponse(responseCode = "204", description = "User excluded")
    @APIResponse(responseCode = "400", description = "Bad request")
    @APIResponse(responseCode = "500", description = "Internal error")
    @Path("{cpf}")
    public void deleteByCpf(@PathParam String cpf) {
        userService.deleteByCpf(cpf);
    }
}