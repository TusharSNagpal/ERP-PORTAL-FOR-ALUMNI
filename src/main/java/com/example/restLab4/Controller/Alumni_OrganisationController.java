
package com.example.restLab4.Controller;

import com.example.restLab4.Bean.Alumni_Organisation;
import com.example.restLab4.DAO.Alumni_OrganisationDAO;
import com.example.restLab4.DAO.DAOImplementation.Alumni_OrganisationDAOImpl;
import com.example.restLab4.HelloApplication;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/alumni_org")
public class Alumni_OrganisationController extends HelloApplication {
    Alumni_OrganisationDAO alumni_organisationDAO = new Alumni_OrganisationDAOImpl();

    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register_alumni_org(Alumni_Organisation aluObj){
        if(this.alumni_organisationDAO.registerAlumniOrg(aluObj)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(404).entity("Failure while adding alumni").build();
    }

//    @GET
//    @Path("/getGrad/{grad_year}/{fname}/{lname}")
//    @Produces(MediaType.APPLICATION_JSON)
//    //@Consumes(MediaType.TEXT_PLAIN)
//    public Response get_students(@PathParam("grad_year") int year, @PathParam("fname") String fname, @PathParam("lname") String lname){
//        System.out.println(year);
//
//        List<Students> stud = this.studentsDAO.getStudentByGradYearName(year, fname, lname);
//        //stud.setGraduation_year(stud.getGraduation_year());
//
//        System.out.println(stud);
//
//        return Response.status(200).entity(stud).build();
//    }
////start
//    @GET
//    @Path("/get/{stud_id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    //@Consumes(MediaType.TEXT_PLAIN)
//    public Response get_student(@PathParam("stud_id") int id){
//        System.out.println(id);
//
//        Students stud = this.studentsDAO.getStudentByID(id);
//        stud.setStudent_id(stud.getStudent_id());
//        System.out.println(stud);
//
//        return Response.status(200).entity(stud).build();
//    }
//end
}