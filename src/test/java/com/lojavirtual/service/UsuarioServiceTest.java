package com.lojavirtual.service;

import com.lojavirtual.exceptions.RegraNegocioException;
import com.lojavirtual.model.entity.Usuario;
import com.lojavirtual.model.repository.UsuarioRepository;
import com.lojavirtual.service.impl.UsuarioServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @SpyBean
    private UsuarioServiceImpl service;

    @Autowired
    private UsuarioRepository repository;

    @Test
    public void deveRetornarErroAoTerTodosOsCamposNulos(){
        Usuario usuario = Usuario.builder().build();
        List<String> msg = new ArrayList<>(Arrays.asList(
                "O nome do usuário está vazio",
                "O email do usuário está vazio",
                "A senha do usuário é nula ou vazia!"));

        Throwable throwable = Assertions.catchThrowable(() -> service.salvar(usuario, null));
        Assertions.assertThat(throwable).isInstanceOf(RegraNegocioException.class).hasMessage(String.join("\r\n", msg));
    }

    @Test
    public void deveRetornarErroAoTerNomeEmBrancoECamposNulos(){
        Usuario usuario = Usuario.builder().nome("").build();

        List<String> msg = new ArrayList<>(Arrays.asList(
                "O nome do usuário está vazio",
                "O email do usuário está vazio",
                "A senha do usuário é nula ou vazia!"));

        Throwable throwable = Assertions.catchThrowable(() -> service.salvar(usuario, null));
        Assertions.assertThat(throwable).isInstanceOf(RegraNegocioException.class).hasMessage(String.join("\r\n",msg));
    }
}
