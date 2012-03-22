package org.jcheng.demo.jersey;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jcheng.demo.model.User;
import org.springframework.stereotype.Component;


@Component
@Path("/helloFromJava")
public class HelloJavaResource {

	private static final String[] MESSAGES = { "hello", "world", "from", "Java" };

	// Return JSON or XML based on the 'Accept' header, e.g., 'Accept:
	// application/json'.
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User getUser() {
		User user = new User();
		user.getMessages().addAll(Arrays.asList(MESSAGES));
		user.setAlias("Java");
		user.setEmail("java@example.com");
		return user;
	}

	/**
	 * You should not define separate methods just to provide json and xml
	 * output, however, for the convenience of the users of the demo, we allow
	 * one to see specific formatting with the urls:
	 * 
	 * <code>
	 * http://localhost:8080/rest/helloFromJava/json
	 * http://localhost:8080/rest/helloFromJava/xml
	 * </code>
	 */
	@Path("json")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public User convenienceOnlyGetUserJson() {
		return getUser();
	}

	@Path("xml")
	@GET
	@Produces({ MediaType.APPLICATION_XML })
	public User convenienceOnlyGetUserXml() {
		return getUser();
	}


	public static final void main(String[] argv) {

	}
}