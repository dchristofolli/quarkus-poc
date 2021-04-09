package com.dchristofolli;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    UserService userService;

    @GET
    public List<User> findAll() {
        return userService.findAll();
    }

    @POST
    public Response create(@Valid User user) {
        userService.create(user);
        return Response.status(201).build();
    }

    @GET
    @Path("{cpf}")
    public User findByCpf(@PathParam String cpf){
        return userService.findByCpf(cpf);
    }
}