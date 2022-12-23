
package com.example.restLab4.Controller;

import com.example.restLab4.Bean.Organisation;
import com.example.restLab4.DAO.DAOImplementation.OrganisationDAOImpl;
import com.example.restLab4.DAO.OrganisationDAO;
import com.example.restLab4.HelloApplication;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/organisation")
public class OrganisationController extends HelloApplication {
    OrganisationDAO organisationDAO = new OrganisationDAOImpl();

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_organisation(){
        List<Organisation> orgs = this.organisationDAO.getOrganisation();

        return Response.status(200).entity(orgs).build();
    }
}