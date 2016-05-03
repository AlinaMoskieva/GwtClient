package ru.itis.inform.users.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ru.itis.inform.users.client.api.ParticipantClient;
import ru.itis.inform.users.models.Participants;

import java.util.List;

/**
 * Created by Moskieva on 03.05.16.
 */
public class participants implements EntryPoint {
    private static final String SERVICE_ROOT_URL = "http://localhost:8081/Department-1.3/";
    public void onModuleLoad() {
        Defaults.setServiceRoot(SERVICE_ROOT_URL);
        ParticipantClient client = GWT.create(ParticipantClient.class);

        client.getListOfPArticipants(new MethodCallback<List<Participants>>() {
            public void onFailure(Method method, Throwable throwable) {
                Label label = new Label("Error!");
                RootLayoutPanel.get().add(label);
            }

            public void onSuccess(Method method, List<Participants> response) {
                VerticalPanel verticalPanel = new VerticalPanel();
                for (Participants participants : response){
                    Label label = new Label(participants.toString());
                    label.setStyleName("serverResponseLabel");
                    verticalPanel.add(label);
                }
                RootLayoutPanel.get().add(verticalPanel);
            }
        });

    }
}
