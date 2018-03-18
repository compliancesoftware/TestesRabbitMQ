package br.com.douglasfernandes.UserServices.Testes.ObterUsuario;

import br.com.douglasfernandes.UserServices.UserServicesApplication;
import br.com.douglasfernandes.UserServices.entities.Usuario;
import br.com.douglasfernandes.UserServices.services.UserService;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = UserServicesApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ObterUsuarioPassos {

    private Usuario usuario;

    @Autowired
    private UserService userService;

    @Dado("^pesquisa do usuario com cpf (\\d+)$")
    public void testePesquisaPorCPF(long cpf) throws Throwable {
        usuario = userService.obterUsuarioporCpf(cpf);
    }

    @Entao("^retorna \"(.*?)\"$")
    public void validaNome(String nome) {
        assertEquals(usuario.getNome(), nome);
    }

}
