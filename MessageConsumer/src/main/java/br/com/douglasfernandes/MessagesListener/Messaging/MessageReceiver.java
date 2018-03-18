package br.com.douglasfernandes.MessagesListener.Messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j
public class MessageReceiver {

    @Autowired
    private ObjectMapper objectMapper;

    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
    }
}
