package com.sesac.board.config.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HandlerLoginSucess handlerLoginSucess;

    @Autowired
    HandlerLoginFailure handlerLoginFailure;

    @Autowired
    HandlerLogoutSucess handlerLogoutSucess;

    @Autowired
    HandlerAccessDeny handlerAccessDeny;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /* 인가처리 */
        http.authorizeRequests()
                .antMatchers("/", "/home","/comm/**","/img/**","/css/**","/js/**","/docs/**","/secure/login").permitAll()
                //.antMatchers("/study/**").hasAnyAuthority("ROLE_MEMBER","ROLE_ADMIN")
                //.antMatchers("/member/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/study/**").hasAnyRole("MEMBER","ADMIN")
                .antMatchers("/member/**").hasRole("ADMIN")
                .anyRequest().authenticated();

        /* formLogi 부분 */
        http.formLogin()
                .loginPage("/secure/login")
                .loginProcessingUrl("/secure/login_exe")
                //.usernameParameter("user_name")
                //.passwordParameter("pass_word")
                .successHandler(handlerLoginSucess) // 로그인 성공시 실행 부분
                .failureHandler(handlerLoginFailure) // 로그인 실패시 실행 부분
                //.defaultSuccessUrl("/") // successHandler 가 무시된다.
                .permitAll();

        http.logout()
                .logoutSuccessHandler(handlerLogoutSucess)
                .permitAll();

        http.exceptionHandling()
                .accessDeniedHandler(handlerAccessDeny); // 인가권한 없는 사용자일경우

        http.csrf()
                .disable();
    }
}