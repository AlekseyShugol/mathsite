//package com.project.mathsite;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                // CORS для API
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
//
//                // CSRF - отключаем для API, включаем для форм
//                .csrf(csrf -> csrf
//                        .ignoringRequestMatchers("/api/**", "/webhook/**")
//                )
//
//                // Security headers
//                .headers(headers -> headers
//                        .contentSecurityPolicy(csp -> csp
//                                .policyDirectives("default-src 'self'; script-src 'self' 'unsafe-inline'")
//                        )
//                        .frameOptions(frame -> frame.sameOrigin())
//                )
//
//                // Авторизация запросов
//                .authorizeHttpRequests(authz -> authz
//                        // Публичные endpoints
//                        .requestMatchers("/", "/login", "/register", "/public/**").permitAll()
//
//                        // API с разным уровнем доступа
//                        .requestMatchers("/api/public/**").permitAll()
//                        .requestMatchers("/api/user/**").hasRole("USER")
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
//
//                        // УБИРАЕМ hasIpAddress - используем access()
//                        .requestMatchers("/monitoring/**").access(
//                                new org.springframework.security.authorization.AuthenticatedAuthorizationManager<>()
//                        )
//
//                        // Все остальное - требует аутентификации
//                        .anyRequest().authenticated()
//                )
//
//                // Аутентификация
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/dashboard")
//                        .failureUrl("/login?error=true")
//                )
//
//                // Remember Me
//                .rememberMe(remember -> remember
//                        .key("uniqueAndSecret")
//                        .tokenValiditySeconds(86400)
//                )
//
//                // Логаут
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                        .deleteCookies("JSESSIONID")
//                );
//
//        // УБИРАЕМ кастомные фильтры (пока что) - они не нужны для базовой настройки
//        // .addFilterBefore(new RequestLoggingFilter(), UsernamePasswordAuthenticationFilter.class)
//        // .addFilterAfter(new SecurityHeadersFilter(), HeaderWriterFilter.class);
//
//        return http.build();
//    }
//
//    // CORS конфигурация
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList(
//                "http://localhost:3000",  // ваш фронтенд
//                "https://trusted-domain.com"
//        ));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);  // Для всех путей
//        return source;
//    }
//}