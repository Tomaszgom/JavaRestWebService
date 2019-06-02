package webService;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author Admin
 * Purchase Orders RESTful Web Serice
 *
 */

@Path("/ordersService")
public class porders {
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/porders-list")
	public String pordersListXML(){
		
		String response="<?xml version='1.0'?>"
				+"<porders>"
					+"<message>"
					+"<msg>This is response from Java REST Web Service. List of purchase orders in XML format.</msg>"
					+"<result>successful</result>"
					+"</message>"	
					+"<order>"
						+"<ID>001</ID>"
						+"<value>120</value>"
						+"<product>Product01</product>"
					+"</order>"					
					+"<order>"
						+"<ID>002</ID>"
						+"<value>220</value>"
						+"<product>Product02</product>"
					+"</order>"
					+"<order>"
						+"<ID>003</ID>"
						+"<value>160</value>"
						+"<product>Product03</product>"
					+"</order>"
				+"</porders>";
		
		return response;
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/porders-list-json")
	public String pordersListJSON(){
		
		String response="<?xml version='1.0'?>"
				+"<porders>"
					+"<message>"
					+"<msg>This is response from Java REST Web Service. List of purchase orders in JSON format.</msg>"
					+"<result>successful</result>"
					+"</message>"	
					+"<order>"
						+"<ID>001</ID>"
						+"<value>120</value>"
						+"<product>Product01</product>"
					+"</order>"					
					+"<order>"
						+"<ID>002</ID>"
						+"<value>220</value>"
						+"<product>Product02</product>"
					+"</order>"
					+"<order>"
						+"<ID>003</ID>"
						+"<value>160</value>"
						+"<product>Product03</product>"
					+"</order>"
				+"</porders>";

		return response;
	}
	
	
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("/{id}")
	public String getOrderXML(@PathParam("id") String id){

		String response;
		switch(id) {
			case "001":
					response="<?xml version='1.0'?>"
						+"<porders>"
							+"<message>"
							+"<msg>Response from Java REST Web Service</msg>"
							+"<result>Successful</result>"
							+"</message>"	
							+"<order>"
								+"<ID>001</ID>"
								+"<value>120</value>"
								+"<product>Product01</product>"
							+"</order>"
						+"</porders>";
				break;
				
			case "002":
					response="<?xml version='1.0'?>"
						+"<porders>"
							+"<message>"
							+"<msg>Response from Java REST Web Service</msg>"
							+"<result>Successful</result>"
							+"</message>"	
							+"<order>"
								+"<ID>002</ID>"
								+"<value>220</value>"
								+"<product>Product02</product>"
							+"</order>"
						+"</porders>";
				break;
			case "003":
					response="<?xml version='1.0'?>"
							+"<porders>"
								+"<message>"
								+"<msg>Response from Java REST Web Service</msg>"
								+"<result>Successful</result>"
								+"</message>"	
								+"<order>"
									+"<ID>003</ID>"
									+"<value>160</value>"
									+"<product>Product03</product>"
								+"</order>"
							+"</porders>";
					break;

			default:
			 		response="<?xml version='1.0'?>"
					+"<porders>"
						+"<message>"
						+"<msg>Response from Java REST Web Service: No such order ID.</msg>"
						+"<result>Unsuccessful</result>"
						+"</message>"	
					+"</porders>";
			break;
			
		}
		
		return response;	
	}

}
