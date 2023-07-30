package com.ustc.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author :Yangyang Miao
 * @date :2023-07-30 21:53:00
 */
@Configuration
public class AppSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests(requests -> {
            // 1.首页所有人都能访问
            requests.requestMatchers("/").permitAll()
                    // 2.剩下的任意请求都需要认证
                    .anyRequest().authenticated();
        });
        // 3.自定义登录规则
        http.formLogin(formLogin -> {
            // 自定义登录页位置，并且所有人都能访问
            formLogin.loginPage("/login").defaultSuccessUrl("/success").failureUrl("/error").permitAll();
        });
        return http.build();
    }

    @Bean
    // 查询用户数据详情的
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // 模拟内存中保存所有用户信息，此处也可以查询数据库
        UserDetails user01 = User.withUsername("miaoyangyang01").password(passwordEncoder.encode("112233")).roles("admin").build();
        UserDetails user02 = User.withUsername("miaoyangyang02").password(passwordEncoder.encode("112233")).roles("manager").build();
        UserDetails user03 = User.withUsername("miaoyangyang03").password(passwordEncoder.encode("112233")).roles("HR").build();
        return new InMemoryUserDetailsManager(user01, user02, user03);
    }

    // 密码加密存储到内存，也可以存储到数据库
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
