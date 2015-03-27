package com.github.oliverbauer.tapestry.resteasy.example.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.github.oliverbauer.tapestry.resteasy.example.entities.User;

public class UserDAOImpl implements UserDAO {
	@Inject
	private Session session;
	
	@Override
	public Response create(User user) {
		if (user.getMail() == null) {
			return Response.status(403).build();
		}
		
		// we check if there is already someone set with the mail...
		boolean denied = session
				.createCriteria(User.class)
				.add(Restrictions.eq("mail", user.getMail()))
				.list().size() > 0;
				
		if (denied) {
			return Response.status(403).build();
		}
		
		session.save(user);
		return Response.ok().build();
	}

	@Override
	public Response read(String mail) {
		User user = (User)session
				.createCriteria(User.class)
				.add(Restrictions.eq("mail", mail))
				.uniqueResult();
		if (user == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(user, MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response update(User user) {
		session.update(user);
		return Response.ok().build();
	}

	@Override
	public Response delete(User user) {
		session.delete(user);
		return Response.ok().build();
	}
}
