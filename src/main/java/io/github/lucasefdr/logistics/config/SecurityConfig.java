package io.github.lucasefdr.logistics.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Log4j2
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/api/v1/admin/**")
                        .hasRole("ADMIN")
                        .antMatchers("/api/v1/**")
                        .hasRole("USER")
                        .anyRequest()
                        .authenticated())
                .formLogin()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * <b>In memory auth</b>
     * @param auth
     * @return <code>InMemoryUserDetailsManager</code>
     * @throws Exception
     */
    @Bean
    public InMemoryUserDetailsManager users(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user1 = User
                .withUsername("laramfdr")
                .password(passwordEncoder().encode("pass"))
                .roles("USER")
                .build();

        List<UserDetails> users = new ArrayList<>();
        users.add(user1);

        return new InMemoryUserDetailsManager(users);
    }

}
