package ru.itis.inform.users.client.api;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ru.itis.inform.users.models.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

public interface UsersClient extends RestService {

    @POST
    @Path("/signup")
    void addUser(UserDto dto, MethodCallback<String> callback);

    @GET
    @Path("/documents")
    void getListing(String token, MethodCallback<DocumentsDto>callback);

    @POST
    @Path("/documents")
    void addNewDocument(DocumentDto dto, String token, MethodCallback callback);

    @POST
    @Path("/document/{documentId}/additional")
    void addNewAdditional();
}
