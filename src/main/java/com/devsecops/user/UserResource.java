package com.devsecops.user;

import com.devsecops.user.model.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.validation.Valid;

@Path("/api/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
public Response createUser(@Valid User user) {

    if (user == null) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("User data is required")
                .build();
    }

    user.setId(1L);

    return Response.status(Response.Status.CREATED)
            .entity(user)
            .build();
}
}
