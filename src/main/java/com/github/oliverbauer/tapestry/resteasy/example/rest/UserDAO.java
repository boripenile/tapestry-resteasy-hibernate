package com.github.oliverbauer.tapestry.resteasy.example.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.github.oliverbauer.tapestry.resteasy.example.entities.User;

@Path("/user")
public interface UserDAO {
	@POST
	@Path("create")
	@Consumes("application/json")
	@CommitAfter
	Response create(User user);

	@GET
	@Path("read/{mail}")
	@Produces("application/json")
	Response read(@PathParam("mail") String mail);
	
	@POST
	@Path("update")
	@Consumes("application/json")
	@CommitAfter
	Response update(User user);

	@POST
	@Path("delete")
	@Consumes("application/json")
	@CommitAfter
	Response delete(User user);
}
