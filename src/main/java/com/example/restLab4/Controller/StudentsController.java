
package com.example.restLab4.Controller;

import com.example.restLab4.Bean.Students;
import com.example.restLab4.DAO.DAOImplementation.StudentsDAOImpl;
import com.example.restLab4.DAO.StudentsDAO;
import com.example.restLab4.HelloApplication;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/students")

public class StudentsController extends HelloApplication {
    StudentsDAO studentsDAO = new StudentsDAOImpl();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_student(Students stud){
        if(this.studentsDAO.addStudent(stud)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(404).entity("Failure while adding employee").build();
    }

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_employee(){
        List<Students> studs = this.studentsDAO.getStudents();

        return Response.status(200).entity(studs).build();
    }

    @GET
    @Path("/getGrad/{grad_year}/{fname}/{lname}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.TEXT_PLAIN)
    public Response get_students(@PathParam("grad_year") int year, @PathParam("fname") String fname, @PathParam("lname") String lname){
        System.out.println(year);

        List<Students> stud = this.studentsDAO.getStudentByGradYearName(year, fname, lname);
        //stud.setGraduation_year(stud.getGraduation_year());

        System.out.println(stud);

        return Response.status(200).entity(stud).build();
    }
//start
    @GET
    @Path("/get/{stud_id}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.TEXT_PLAIN)
    public Response get_student(@PathParam("stud_id") int id){
        System.out.println(id);

        Students stud = this.studentsDAO.getStudentByID(id);
        stud.setStudent_id(stud.getStudent_id());
        System.out.println(stud);

        return Response.status(200).entity(stud).build();
    }
//end
}