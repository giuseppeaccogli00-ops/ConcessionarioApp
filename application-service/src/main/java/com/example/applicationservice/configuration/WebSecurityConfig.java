package com.example.applicationservice.configuration;



import com.example.applicationservice.jwt.AuthEntryPointJwt;
import com.example.applicationservice.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableMethodSecurity
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {//intercetta richiesta HTTP e valida il token
        return new AuthTokenFilter();
    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {//dice da dove prendere cfredenziali utente e come verificare la password
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {//valida l'utente e lo aggiunge nel Security Context
//        return authConfig.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();//hasha la password con salt e cost factor
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())//disabilito perchè questo non serve con JWT, ma solo con le sessioni
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))//se le credenziali non vanno bene
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//non usare sessioni, ogni richiesta ha JWT
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/autos").permitAll()
                                .requestMatchers("/macchinas/**").permitAll()
                                .requestMatchers("/clientes/**").permitAll()
                                .requestMatchers("/fornitores").permitAll()
                                .requestMatchers("/venditas/**").permitAll()
                                .requestMatchers("/venditores").permitAll()
                                .requestMatchers("/venditores/random").permitAll()
                                .requestMatchers("/reports").permitAll()
                                .requestMatchers(
                                        "/swagger-ui.html",
                                        "/swagger-ui/**",
                                        "/v3/api-docs/**"
                                ).permitAll()
                                .anyRequest().authenticated()

                );

//        http.authenticationProvider(authenticationProvider());//attacco il provider che ho definito prima

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);//permette di utilizzare il filtro JWT prima, quando richiamo il filtro standard l'utente è già autencitcato

//        http.oauth2ResourceServer(o -> o.jwt());
//        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        return http.build();
    }
}
