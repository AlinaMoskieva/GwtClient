package ru.itis.inform.users.client.api;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ru.itis.inform.users.models.User;
import ru.itis.inform.users.models.UserDto;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/signup")
public interface UsersClient extends RestService {

    @POST
    void addUser(UserDto dto, MethodCallback<String> callback);
}
