package ru.itis.inform.users.client.api;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ru.itis.inform.users.models.User;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/users")
public interface UsersClient extends RestService {


    @GET
    void getUser(MethodCallback<User> callback);
    @POST
    void addUser(MethodCallback<String> callback);
}
