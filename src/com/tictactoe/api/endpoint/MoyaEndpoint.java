package com.tictactoe.api.endpoint;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tictactoe.api.request.GameRequest;

@WebService(name = "moyaService", targetNamespace = "http://www.moya.com/service")
@Path("/core/config")
public interface MoyaEndpoint {
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/token")
	public Response getToken();

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ping")
	public Response getPing();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getGameState")
	public Response getGameState(GameRequest gameRequest);

}
