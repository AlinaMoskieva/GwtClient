package ru.itis.inform.users.client.api;

import org.fusesource.restygwt.client.MethodCallback;
import ru.itis.inform.users.models.Participants;

import java.util.List;

/**
 * Created by Moskieva on 03.05.16.
 */
public interface ParticipantClient {
    void getListOfPArticipants(MethodCallback<List<Participants>> callback);
    void addParticipants();
}
