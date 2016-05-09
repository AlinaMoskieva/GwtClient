package ru.itis.inform.users.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ru.itis.inform.users.client.api.UsersClient;
import ru.itis.inform.users.models.User;


/**
 * Created by Moskieva on 04.05.16.
 */
public class MainEntryPoint implements EntryPoint, ValueChangeHandler {
    private static final String SERVICE_ROOT_URL = "http://localhost:8081/Department-1.4/";
    VerticalPanel verticalPanel = new VerticalPanel();
    Label label = new Label();



    public void onModuleLoad() {
        Defaults.setServiceRoot(SERVICE_ROOT_URL);

        Hyperlink hyperlinkToListDocuments = new Hyperlink("link to documents", "getDocuments");
        Hyperlink hyperlinkToDocument = new Hyperlink("link to document", "getDocumentById");
        Hyperlink hyperlinkToParticipant = new Hyperlink("linkto participants", "getListOfParticipants");
        Hyperlink hyperlinkToAddNewDocument = new Hyperlink("add new Document", "addNewDocument");
        Hyperlink linkToAddAdditional = new Hyperlink("add Participants", "addNewParticipant");

        verticalPanel.getElement().getStyle().setProperty("marginLeft", "auto");

        verticalPanel.add(hyperlinkToAddNewDocument);
        verticalPanel.add(linkToAddAdditional);
        verticalPanel.add(hyperlinkToParticipant);
        verticalPanel.add(hyperlinkToDocument);
        verticalPanel.add(hyperlinkToListDocuments);


        RootPanel.get().add(verticalPanel);
        History.addValueChangeHandler(this);

        changePage(History.getToken());
        addRegistredForm();

    }

    public void onValueChange(ValueChangeEvent valueChangeEvent) {
        changePage(History.getToken());

    }
    public void changePage(String token) {
        if (History.getToken().equals("browse")) {
            label.setText("Here would be some books");
        } else if (History.getToken().equals("details")) {
            label.setText("Here would be the user details");
        } else {
            label.setText("Welcome page");
        }
    }

    public void addRegistredForm(){
        final FormPanel form = new FormPanel();
        form.setAction("/signup");
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);
        form.setHeight("10");

        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        form.setWidget(panel);

        final TextBox tb = new TextBox();
        final Label label = new Label("Email");
        tb.setWidth("220");
        tb.setName("Email");

        final TextBox tb1 = new TextBox();
        final Label label1 = new Label("Name");
        tb1.setWidth("220");
        tb1.setName("Name");

        final TextBox tb2 = new TextBox();
        final Label label2 = new Label("Password");
        tb2.setWidth("220");
        tb2.setName("Password");

        final TextBox tb3 = new TextBox();
        final Label label3 = new Label("Сonfirmation password");
        tb2.setWidth("220");
        tb2.setName("Сonfirmation");

        final Label registrationLabel = new Label("Sign up");

        panel.add(registrationLabel);
        panel.add(label);
        panel.add(tb);
        panel.add(label1);
        panel.add(tb1);
        panel.add(label2);
        panel.add(tb2);
        panel.add(label3);
        panel.add(tb3);


        panel.add(new Button("Sign up", new ClickHandler() {
            public void onClick(ClickEvent event) {
                form.submit();
            }
        }));

        form.addSubmitHandler(new FormPanel.SubmitHandler() {
            public void onSubmit(SubmitEvent event) {
                String message="";
                if (tb.getText().length() == 0 || tb1.getText().length() == 0 ||
                        tb2.getText().length() == 0 || tb3.getText().length() == 0) {

                    if (tb.getText().length() == 0 ){
                        message += tb.getName() + " ";
                    }
                    if (tb1.getText().length() == 0){
                        message += tb1.getName() + " ";
                    }
                    if (tb2.getText().length() == 0){
                        message += tb2.getName() + " ";
                    }
                    if (tb3.getText().length() == 0){
                        message += tb3.getName() + " ";
                    }

                    Window.alert("The "+ message +" text box must not be empty");
                    event.cancel();
                }

                if (! tb2.getText().equals(tb3.getText())){
                    Window.alert("Passwords are different");
                }

                if (tb.getText().length() < 3 || tb1.getText().length() < 3 || tb2.getText().length() < 3 ){
                    Window.alert("Email, name and password must be more than 2 ");

                }

                UsersClient client = GWT.create(UsersClient.class);



                client.addUser(new MethodCallback<String>() {

                    public void onFailure(Method method, Throwable throwable) {
                        VerticalPanel panel =  new VerticalPanel();
                        Label label = new Label("E"+ throwable.getMessage());
                        panel.add(label);
                        RootPanel.get().add(panel);
                    }

                    public void onSuccess(Method method, String s) {
                        VerticalPanel panel = new VerticalPanel();
                        Label label = new Label("Ok" + s);
                        panel.add(label);
                        RootLayoutPanel.get().add(panel);

                    }

                });
            }
        });

        DecoratorPanel decoratorPanel = new DecoratorPanel();
        decoratorPanel.getStylePrimaryName();
        decoratorPanel.add(form);
        RootPanel.get().add(decoratorPanel);

    }
    

}
