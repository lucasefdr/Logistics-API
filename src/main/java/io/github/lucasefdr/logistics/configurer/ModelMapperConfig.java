package io.github.lucasefdr.logistics.configurer;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b>@Configuration</b> é uma anotação que indica que essa classe será processada pelo container do Spring e
 * indica que essa classe possui métodos que expõe novos <b>beans</b>.
 *
 */
@Configuration
public class ModelMapperConfig {

    /**
     * <b>@Bean</b> é uma anotação utilizada em cima dos métodos de uma classe, geralmente marcada com <b>@Configuration</b>,
     * indicando que o Spring deve invocar aquele método e gerenciar o objeto retornado por ele.
     * Quando digo gerenciar é que agora este objeto pode ser injetado em qualquer ponto da sua aplicação.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
