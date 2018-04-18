package ir.maktab.api;

import com.google.gson.Gson;
import ir.maktab.entities.Student;
import ir.maktab.manager.StudentManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/service")
public class Service {

    @Path("/student/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String create(Student student) {
        try {
            StudentManager.getInstance().create(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "That work perfectly";
    }

    @Path("/student/read")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String read(@QueryParam("id") Integer id) {
        try {
            return new Gson().toJson(StudentManager.getInstance().read(id));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Path("/student/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() {
        try {
            return new Gson().toJson(StudentManager.getInstance().list());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Path("/student/update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String update(Student student) {
        try {
            StudentManager.getInstance().update(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "That work perfectly";
    }

    @Path("/student/delete")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@QueryParam("id") Integer id) {
        try {
            StudentManager.getInstance().delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "That work perfectly";
    }

}