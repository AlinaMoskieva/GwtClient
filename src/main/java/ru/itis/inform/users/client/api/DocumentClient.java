package ru.itis.inform.users.client.api;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import ru.itis.inform.users.models.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by Moskieva on 02.05.16.
 */

@Path("/document")
public interface DocumentClient  extends RestService {

    @GET
    void getDocument(MethodCallback<Document> callback);
    void getListOfUserDocuments (MethodCallback<List<Document>> callback);
    void  addDocument();

}
