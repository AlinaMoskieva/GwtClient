package ru.itis.inform.users.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ru.itis.inform.users.client.api.DocumentClient;
import ru.itis.inform.users.models.Document;
import com.google.gwt.user.client.ui.Label;

import java.util.List;

/**
 * Created by Moskieva on 02.05.16.
 */
public class document implements EntryPoint {
    private static final String SERVICE_ROOT_URL = "http://localhost:8081/Department-1.3/";
    public void onModuleLoad() {
        Defaults.setServiceRoot(SERVICE_ROOT_URL);
        DocumentClient documentClient = GWT.create(DocumentClient.class);

        documentClient.getDocument(new MethodCallback<Document>() {
            public void onFailure(Method method, Throwable throwable) {
                Label label = new Label("Error!");
                RootLayoutPanel.get().add(label);
            }

            public void onSuccess(Method method, Document document) {
                VerticalPanel panel = new VerticalPanel();
                Label label = new Label(document.toString());
                panel.add(label);
                RootLayoutPanel.get().add(panel);
            }
        });

        documentClient.getListOfUserDocuments(new MethodCallback<List<Document>>() {
            public void onFailure(Method method, Throwable throwable) {
                Label label = new Label("Error");
                RootLayoutPanel.get().add(label);
            }

            public void onSuccess(Method method, List<Document> documents) {
                VerticalPanel verticalPanel = new VerticalPanel();
                for(Document document : documents){
                    Label label = new Label(document.toString());
                    label.setStyleName("serverResponseLabel");
                    verticalPanel.add(label);
                }
                RootLayoutPanel.get().add(verticalPanel);


            }
        });
    }
}
