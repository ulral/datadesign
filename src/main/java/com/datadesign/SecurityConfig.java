package com.datadesign;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests((authz) -> authz
//                    .anyRequest().permitAll() // 모든 요청에 대해 인증을 요구하지 않음
//                    // .requestMatchers("/").permitAll() // "/"는 인증 필요 없음
//                    // .anyRequest().authenticated()     // 그 외는 인증 필요
//                )
//                .formLogin(Customizer.withDefaults()); // 기본 로그인 폼 사용
//            return http.build();
//    }
}