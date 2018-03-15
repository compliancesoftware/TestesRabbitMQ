package br.com.douglasfernandes.MessagesListener.Messaging;

import br.com.douglasfernandes.MessagesListener.models.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sun.security.provider.certpath.OCSPResponse;

import java.io.IOException;
import java.io.Serializable;

@Component
@Log4j
public class MessageReceiver {

    @Autowired
    private ObjectMapper objectMapper;

    public void receiveMessage(byte[] message) throws IOException {
        System.out.println("Received <" + new String(message) + ">");
    }
}
