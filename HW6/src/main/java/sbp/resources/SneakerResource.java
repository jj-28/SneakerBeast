/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp.resources;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jersey.repackaged.com.google.common.base.Optional;
import sbp.api.Sneaker;
import sbp.db.SneakerDAO;
/**
 *
 * @author Jeffrey
 */


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class SneakerResource {
private SneakerDAO SneakerDAO;

public SneakerResource(SneakerDAO SneakerDAO) {
this.SneakerDAO = SneakerDAO;    
}

@POST
@Path("/{sneakers}")
@UnitOfWork
@Consumes(MediaType.APPLICATION_JSON)
public Response addSneaker(Sneaker s) throws Exception {
    try {
    Sneaker made =SneakerDAO.create(s);
return Response.status(Response.Status.CREATED).entity(made).build();
    }catch (Exception e) {
        e.printStackTrace();
    }
    return Response.ok(this).build();
}

@GET
@Path("/{sneakers}")
@UnitOfWork
@Produces(MediaType.APPLICATION_JSON)
public List<Sneaker> returnAllSneakers (){
    return SneakerDAO.getAllSneakers();
} 

@GET
@Path("/sneakers/{id}")
@UnitOfWork
@Produces(MediaType.APPLICATION_JSON)
public Response findSneaker(@PathParam("id") long id) {
    try {
        Sneaker sneaker = SneakerDAO.findById(id);
        return Response.ok(sneaker).build();
    } catch (NullPointerException e) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
@DELETE
@UnitOfWork
@Path("/sneakers/{id}")
public Response delete(@PathParam("id") long id) {
    if (SneakerDAO.findById(id) != null) {
          SneakerDAO.delete(SneakerDAO.findById(id));
          return Response.status(Response.Status.NO_CONTENT).build();
    }else {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}


}