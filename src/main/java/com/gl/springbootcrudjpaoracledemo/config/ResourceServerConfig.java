package com.gl.springbootcrudjpaoracledemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**A Resource Server (can be the same as the Authorization Server or a separate application) serves resources that are protected by the OAuth2 token.
 * Spring OAuth provides a Spring Security authentication filter that implements this protection.
 *  You can switch it on with @EnableResourceServer on an @Configuration class, and configure it (as necessary) using a ResourceServerConfigurer.
 *The @EnableResourceServer annotation adds a filter of type OAuth2AuthenticationProcessingFilter automatically
 *to the Spring Security filter chain.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .headers()
                .frameOptions()
                .disable()
                .and()
            .authorizeRequests()
                .antMatchers("/","/home","/register","/login").permitAll()
                .antMatchers("/private/**","/users/**").authenticated();
    }


}
