package ru.itis.inform.users.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import ru.itis.inform.users.client.api.UsersClient;
import ru.itis.inform.users.models.UserDto;

/**
 * Created by Moskieva on 16.05.16.
 */
public class Forms {

    public void addAddDocumentForm(){
        Label label = new Label("Denomination Of Applicant");
        final TextBox tb = new TextBox();
        tb.setName("Denomination Of Applicant");
        Label label1 = new Label("Legal Status Of The Applicant");
        final TextBox tb1 = new TextBox();
        tb1.setName("Legal Status Of The Applicant");
        Label label2 = new Label("The Type Labor Arbitrators");
        final TextBox tb2 = new TextBox();
        tb2.setName("The Type Labor Arbitrators");
        Label label3 = new Label("Form Of The Preparation Of Labor Arbitrators");
        final TextBox tb3 = new TextBox();
        tb3.setName("Form Of The Preparation Of Labor Arbitrators");
        Label label4 = new Label("Time Of The Preparation Of Labor Arbitrators");
        final TextBox tb4 = new TextBox();
        tb4.setName("Time Of The Preparation Of Labor Arbitrators");
        Label label5 = new Label("Preferred Location");
        final TextBox tb5 = new TextBox();
        tb5.setName("Preferred Location");
        Label label6 = new Label("Mailing Address Of The Applicant");
        final TextBox tb6 = new TextBox();
        tb6.setName("Mailing Address Of The Applicant");
        Label label7 = new Label("Contact Phone Numbers");
        final TextBox tb7 = new TextBox();
        tb7.setName("Contact Phone Numbers");
        Label label8 = new Label("Email Address");
        final TextBox tb8 = new TextBox();
        tb8.setName("Email Address");
        Label label9 = new Label("Position Applicant");
        final TextBox tb9 = new TextBox();
        tb9.setName("Position Applicant");
        Label label10 = new Label("Full Name");
        final TextBox tb10 = new TextBox();
        tb10.setName("Full Name");
        Label label11 = new Label("Date");
        final TextBox tb11 = new TextBox();
        tb11.setName("Date");


        final FormPanel form = new FormPanel();
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);
        form.setHeight("10");

        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        form.setWidget(panel);

        panel.add(label);
        panel.add(tb);
        panel.add(label1);
        panel.add(tb1);
        panel.add(label2);
        panel.add(tb2);
        panel.add(label3);
        panel.add(tb3);
        panel.add(label4);
        panel.add(tb4);
        panel.add(label5);
        panel.add(tb5);
        panel.add(label6);
        panel.add(tb6);
        panel.add(label7);
        panel.add(tb7);
        panel.add(label8);
        panel.add(tb8);
        panel.add(label9);
        panel.add(tb9);
        panel.add(label10);
        panel.add(tb10);
        panel.add(label11);
        panel.add(tb11);

        panel.add(new Button("Sign up", new ClickHandler() {
            public void onClick(ClickEvent event) {
                form.submit();
            }
        }));
        form.addSubmitHandler(new FormPanel.SubmitHandler() {
            public void onSubmit(FormPanel.SubmitEvent event) {
                UserDto userDto = new UserDto();
                String message="";
                if (tb.getText().length() == 0 || tb1.getText().length() == 0 ||
                        tb2.getText().length() == 0 || tb3.getText().length() == 0 ||
                        tb4.getText().length() == 0 || tb5.getText().length() == 0 ||
                        tb6.getText().length() == 0 || tb7.getText().length() == 0 ||
                        tb8.getText().length() == 0 || tb9.getText().length() == 0 ||
                        tb10.getText().length() == 0 || tb11.getText().length() == 0)  {

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
                    if (tb8.getText().length() == 0){
                        message += tb8.getName() + " ";
                    }
                    if (tb9.getText().length() == 0){
                        message += tb9.getName() + " ";
                    }
                    if (tb10.getText().length() == 0){
                        message += tb10.getName() + " ";
                    }
                    if (tb11.getText().length() == 0){
                        message += tb11.getName() + " ";
                    }

                    Window.alert("The "+ message +"text box must not be empty");
                    event.cancel();
                }
            }
        });

        DecoratorPanel decoratorPanel = new DecoratorPanel();
        decoratorPanel.getStylePrimaryName();
        decoratorPanel.add(form);
        RootPanel.get().add(decoratorPanel);

    }
}
