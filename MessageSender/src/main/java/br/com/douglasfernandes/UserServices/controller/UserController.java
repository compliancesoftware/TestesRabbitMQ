package br.com.douglasfernandes.UserServices.controller;

import br.com.douglasfernandes.UserServices.Messaging.MessageSender;
import br.com.douglasfernandes.UserServices.entities.Usuario;
import br.com.douglasfernandes.UserServices.models.ResponseBody;
import br.com.douglasfernandes.UserServices.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSender messageSender;

    @GetMapping(value = "/usuario/listar")
    public ResponseBody listar() {
        ResponseBody response = new ResponseBody();
        try {
            List<Usuario> usuarios = userService.listarUsuarios();
            if(usuarios != null && usuarios.size() > 0) {
                response.setEntities(usuarios);
                response.setMessage("Usuarios listados com exito.");
                response.setStatus(ResponseBody.STATUS_OK);
            }
            else {
                response.setMessage("Erro ao tentar listar usuarios.");
            }
        } catch(RuntimeException ex) {
            log.info("Erro ao tentar obter usuarios. Verifique o stacktrace seguinte:");
            ex.printStackTrace();

            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/usuario/{cpf}")
    public ResponseBody obterUsuarioPorCpf(@PathVariable("cpf") String cpf) {
        ResponseBody response = new ResponseBody();
        try {
            long cpfAslong = new Long(cpf);
            Usuario usuario = userService.obterUsuarioporCpf(cpfAslong);
            if(usuario != null) {
                response.setEntity(usuario);
                response.setMessage("Usuario encontrado com exito.");
                response.setStatus(ResponseBody.STATUS_OK);
            }
            else {
                response.setMessage("Usuario não encontrado.");
            }
        } catch(RuntimeException ex) {
            log.info("Erro ao tentar encontrar usuario. Verifique o stacktrace seguinte:");
            ex.printStackTrace();

            response.setMessage(ex.getMessage());
        }

        messageSender.send("UserServicesExchange","UserServices", response.toString());

        return response;
    }

    @PostMapping(value = "/usuario/salvar")
    public ResponseBody salvar(@RequestBody Usuario usuario) {
        ResponseBody response = new ResponseBody();

        try {
            Usuario salvo = userService.salvarUsuario(usuario);
            if(salvo != null) {
                response.setEntity(salvo);
                response.setMessage("Usuario salvo com exito.");
                response.setStatus(ResponseBody.STATUS_OK);
            }
            else {
                response.setMessage("Erro ao tentar salvar usuario.");
            }
        } catch(RuntimeException ex) {
            log.info("Erro ao tentar salvar usuario. Verifique o stacktrace seguinte:");
            ex.printStackTrace();

            response.setMessage(ex.getMessage());
        }

        return response;
    }
}
