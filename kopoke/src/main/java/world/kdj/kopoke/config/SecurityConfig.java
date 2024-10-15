package world.kdj.kopoke.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http, CustomOAuth2SuccessHandler successHandler)
                        throws Exception {
                http
                                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // CORS 설정
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/").permitAll() // 홈 페이지는 누구나 접근 가능
                                                .anyRequest().authenticated() // 다른 모든 요청은 인증 필요
                                )
                                .oauth2Login(oauth2 -> oauth2
                                                .loginPage("/oauth2/authorization/google") // 로그인 페이지 설정
                                                .successHandler(successHandler) // 커스텀 성공 핸들러 설정
                                )
                                .logout(logout -> logout
                                                .logoutUrl("/logout") // 로그아웃 URL
                                                .logoutSuccessUrl("/") // 로그아웃 성공 후 리다이렉트할 URL
                                                .invalidateHttpSession(true) // 세션 무효화
                                                .clearAuthentication(true) // 인증 정보 초기화
                                );

                return http.build();
        }

        @Bean
        public CorsFilter corsFilter() {
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowCredentials(true);
                config.addAllowedOrigin("http://localhost:5173"); // 허용할 프론트엔드 도메인
                config.addAllowedHeader("*");
                config.addAllowedMethod("*");
                source.registerCorsConfiguration("/**", config);
                return new CorsFilter(source);
        }

        // CORS 설정을 위한 별도 메서드
        private UrlBasedCorsConfigurationSource corsConfigurationSource() {
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowCredentials(true);
                config.addAllowedOrigin("http://localhost:5173");
                config.addAllowedHeader("*");
                config.addAllowedMethod("*");
                source.registerCorsConfiguration("/**", config);
                return source;
        }
}
