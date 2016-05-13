package ru.itis.inform.users.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
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
import ru.itis.inform.users.models.UserDto;


/**
 * Created by Moskieva on 04.05.16.
 */
public class MainEntryPoint implements EntryPoint, ValueChangeHandler {
    private static final String SERVICE_ROOT_URL = "http://localhost:8081/Department-1.5/";
    VerticalPanel verticalPanel = new VerticalPanel();
    Label label = new Label();
    TabPanel tabPanel;
    private String token = "";
    private int countUsers = 1;

    private final  String CONST_REQUIREMENT_TO_EMAIL= "Email must be in \"example@gmail.com\" format";
    private final String CONST_REQUIREMENT_TO_USER_NAME = "Letters and numbers, the length of the user name" +
            " is not less than 2 and not more than 20";
    private final  String CONST_REQUIREMENT_TO_PASSWORD = "Letters and numbers, the first letter must be in" +
            " upper case,  the length of the password is not less than 8 and not more than 20";
    private final String CONST_REQUIREMENT_TO_PASSPORT_DATA = "Numbers, the length of passport data must be 10 symbols";
    private final String CONST_REQUIREMENT_TO_SNILS= "Numbers, the length of snils data must be 12 symbols";

    private final String CONST_HISTORY_TOKEN_SIGN_UP = "sign up";
    private final String CONST_HISTORY_TOKEN_LISTING_OF_DOCUMENTS = "listing";
    private final String CONST_HISTORY_TOKEN_ADD_DOCUMENT = "add document";
    private final String CONST_HISTORY_TOKEN_ADD_PARTICIPANT = "add participant";
    private final String CONST_HISTORY_TOKEN_LISTING_OF_PARTICIPANTS = "participants listing";





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

        if (History.getToken().length() == 0) {
            History.newItem("sign_up");
        }
        History.addValueChangeHandler(this);

        changePage(History.getToken());
        //addRegistredForm();

    }

    public void onValueChange(ValueChangeEvent valueChangeEvent) {
        changePage(History.getToken());

    }
    public void changePage(String token) {
        if (History.getToken().equals("sign_up")) {
            addRegistredForm();
        } else label.setText("Not today");

    }








    public void addRegistredForm(){
        final FormPanel form = new FormPanel();
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);
        form.setHeight("10");

        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        form.setWidget(panel);

        final TextBox tb = new TextBox();
        final Label label = new Label("Email");
        final Label requirement_to_email = new Label(CONST_REQUIREMENT_TO_EMAIL);
        tb.setWidth("220");
        tb.setName("Email");

        final TextBox tb1 = new TextBox();
        final Label label1 = new Label("Name");
        final Label requirement_to_name = new Label(CONST_REQUIREMENT_TO_USER_NAME);
        tb1.setWidth("220");
        tb1.setName("Name");

        final TextBox tb2 = new TextBox();
        final Label label2 = new Label("Password");
        final Label requirement_to_password = new Label(CONST_REQUIREMENT_TO_PASSWORD);
        tb2.setWidth("220");
        tb2.setName("Password");

        final TextBox tb3 = new TextBox();
        final Label label3 = new Label("Сonfirmation password");
        tb2.setWidth("220");
        tb2.setName("Сonfirmation");

        final TextBox tb4 = new TextBox();
        final  Label label4 = new Label("Passport data");
        final Label requirement_to_passport = new Label(CONST_REQUIREMENT_TO_PASSPORT_DATA);
        tb4.setWidth("220");
        tb4.setName("PassportData");

        final  TextBox tb5 = new TextBox();
        final Label label5 = new Label("Snils");
        final Label requirement_to_snils = new Label(CONST_REQUIREMENT_TO_SNILS);
        tb5.setWidth("220");
        tb5.setName("Snils");

        final ListBox listBox = new ListBox();
        Label label6 = new Label("Gender");
        listBox.addItem("male", "male");
        listBox.addItem("women", "women");

        final TextBox tb6 = new TextBox();
        Label label7 = new Label("City");
        tb5.setWidth("220");
        tb5.setName("City");

        final TextBox tb7 = new TextBox();
        Label label8 = new Label("Age");
        tb5.setWidth("220");
        tb5.setName("Age");



        final Label registrationLabel = new Label("Sign up");

        panel.add(registrationLabel);
        panel.add(label);
        panel.add(requirement_to_email);
        panel.add(tb);
        panel.add(label1);
        panel.add(requirement_to_name);
        panel.add(tb1);
        panel.add(label4);
        panel.add(requirement_to_passport);
        panel.add(tb4);
        panel.add(label5);
        panel.add(requirement_to_snils);
        panel.add(tb5);
        panel.add(label6);
        panel.add(listBox);
        panel.add(label7);
        panel.add(tb6);
        panel.add(label8);
        panel.add(tb7);

        panel.add(label2);
        panel.add(requirement_to_password);
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
                UserDto userDto = new UserDto();
                String message="";
                if (tb.getText().length() == 0 || tb1.getText().length() == 0 ||
                        tb2.getText().length() == 0 || tb3.getText().length() == 0 ||
                        tb4.getText().length() == 0 || tb5.getText().length() == 0 ||
                        tb6.getText().length() == 0 || tb7.getText().length() == 0)  {

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
                    if (tb4.getText().length() == 0){
                        message += tb4.getName() + " ";
                    }
                    if (tb5.getText().length() == 0){
                        message += tb5.getName() + " ";
                    }
                    if (tb6.getText().length() == 0){
                        message += tb6.getName() + " ";
                    }
                    if (tb7.getText().length() == 0){
                        message += tb7.getName() + " ";
                    }

                    Window.alert("The "+ message +"text box must not be empty");
                    event.cancel();
                }   else{
                        if (! tb2.getText().equals(tb3.getText())) {
                            Window.alert("Passwords are different");
                        }
                    else{
                        if (!tb.getText().matches("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$"))
                            Window.alert("Your email is not valid");
                    else{
                        if (!tb1.getText().matches("^[a-zA-Z0-9-_\\.]{1,20}$")){
                            Window.alert("Your user name is not valid");}
                        else{
                            if (!tb4.getText().matches("[0-9]{10}")){
                                Window.alert("Passport data is not valid.");
                            }
                            else{
                                if(!tb5.getText().matches("[0-9]{12}")){
                                    Window.alert("Snils data is not valid.");
                                }
                                else{
                                    if (!tb6.getText().matches("^[a-zA-Z]+$")){
                                        Window.alert("City data is not valid.");
                                    }
                                    else{ if(!tb7.getText().matches("[0-9]{1,2}")){
                                        Window.alert("Age data is not valid.");
                                    }

                    else{
                        if (!tb2.getText().matches("(?=^.{8,20}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")){
                            Window.alert("Your password is not valid.");
                        }
                    else {

                        UsersClient client = GWT.create(UsersClient.class);


                        userDto.setId(countUsers);
                        userDto.setEmail(tb.getText());
                        userDto.setPassword(tb2.getText());
                        userDto.setUserName(tb1.getText());

                        //userDto.setSnils(tb5.getText());
                            userDto.setAge(tb7.getText());
                            userDto.setCity(tb6.getText());
                            userDto.setPassportData(tb4.getText());
                           userDto.setGender(listBox.getSelectedValue());

                        client.addUser(userDto, new MethodCallback<String>() {

                            public void onFailure(Method method, Throwable throwable) {
                                VerticalPanel panel = new VerticalPanel();
                                Label label = new Label("E" + throwable.getMessage());
                                panel.add(label);
                                RootPanel.get().add(panel);
                            }

                            public void onSuccess(Method method, String s) {
                                countUsers++;
                                VerticalPanel panel = new VerticalPanel();
                                Label label = new Label("Ok" + s);
                                panel.add(label);
                                RootLayoutPanel.get().add(panel);
                                token = s;
                            }

                        });
                    }}}}}}}}}
            }
        });

        DecoratorPanel decoratorPanel = new DecoratorPanel();
        decoratorPanel.getStylePrimaryName();
        decoratorPanel.add(form);
        RootPanel.get().add(decoratorPanel);

    }
}
