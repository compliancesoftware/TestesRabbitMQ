package br.com.douglasfernandes.MessagesListener.models;

import br.com.douglasfernandes.MessagesListener.entities.Entity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponseBody implements Serializable {

    private String message;

    private String status;

    private Entity entity;

    private List<?> entities;

    public static final String STATUS_OK = "Ok";

    public static final String STATUS_ERROR = "Erro";

    public ResponseBody() {
        this.message = "Erro no servidor.";
        this.status = STATUS_ERROR;
        this.entity = null;
    }
}
