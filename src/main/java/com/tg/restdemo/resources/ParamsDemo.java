package com.tg.restdemo.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * 
 * Resource point which is example of different Param types usage
 *
 */

@Path("/paramsdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class ParamsDemo {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,	 // Similar to PathParam but with different syntax
											@HeaderParam("authSessionID") String header, // Custom values in the header, metadata
												@CookieParam("name") String cookie) {	 // Accessing cookies
												/* @FormParam */
			return "Matrix param: " + matrixParam + " Header param: " + header + " Cookie param: " + cookie;
		}
		
		@GET
		@Path("context")
		public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
			
			String path = uriInfo.getAbsolutePath().toString();
			String cookies = headers.getCookies().toString();
			return "Path : " + path + " Cookies: " + cookies;
		}
		
		
		

	}

