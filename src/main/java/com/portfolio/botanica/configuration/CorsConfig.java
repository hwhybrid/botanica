//package com.portfolio.botanica.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig {
//
////    @Bean
////    public CorsFilter corsFilter() {
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        CorsConfiguration config = new CorsConfiguration();
////        config.setAllowCredentials(true);
////        config.addAllowedOrigin("http://localhost:3000");
////        config.addAllowedHeader("*");
////        config.addAllowedMethod("*");
////        source.registerCorsConfiguration("/**", config);
////        return new CorsFilter(source);
////    }
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/**") // Allows CORS for these API endpoints
//                        .allowedOrigins("http://localhost:3000") // Allows requests from the React app
//                        .allowedMethods("GET", "POST", "PUT", "DELETE");
//                // Allows CORS for http://localhost:3000/login
//                registry.addMapping("/login")
//                        .allowedOrigins("http://localhost:3000");
//
//                // Allows CORS for http://localhost:3000/register
//                registry.addMapping("/register")
//                        .allowedOrigins("http://localhost:3000");
//
//                // Allows CORS for just the root endpoint http://localhost:3000/
//                registry.addMapping("/")
//                        .allowedOrigins("http://localhost:3000");
//            }
//        };
//    }
//}
