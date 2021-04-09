package com.dchristofolli;

import javax.inject.Inject;
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
    public List<User> list() {
        return userService.findAll();
    }

    @POST
    public Response add(User user) {
        userService.create(user);
        return Response.status(201).build();
    }
}