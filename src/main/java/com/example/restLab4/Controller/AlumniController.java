
package com.example.restLab4.Controller;

import com.example.restLab4.Bean.Alumni;
import com.example.restLab4.DAO.AlumniDAO;
import com.example.restLab4.DAO.DAOImplementation.AlumniDAOImpl;
import com.example.restLab4.HelloApplication;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/alumni")
public class AlumniController extends HelloApplication {
    AlumniDAO alumniDAO = new AlumniDAOImpl();

    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register_alumni(Alumni aluObj){
        if(this.alumniDAO.registerAlumni(aluObj)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(404).entity("Failure while adding alumni").build();
    }

////start
    @GET
    @Path("/get/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.TEXT_PLAIN)
    public Response get_alumniId(@PathParam("email") String email){
        System.out.println(email);

        Alumni alu = this.alumniDAO.getAlumniByEmail(email);
        //alu.setEmail(alu.getEmail());
        System.out.println(alu);

        return Response.status(200).entity(alu).build();
    }
//end
}