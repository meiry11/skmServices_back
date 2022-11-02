package com.skmServices.skmServices.config;

import com.skmServices.skmServices.filtre.CustomAuthorizationFilter;
import com.skmServices.skmServices.filtre.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;
    @Autowired
    @Lazy
    private BCryptPasswordEncoder bCryptPasswordEncoder;
// AUTHENTIFICATION verifies you re who you say you are
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
// AUTHORIZATION decides if you have permission to access a resource
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);

        http.authorizeRequests().antMatchers("/login","/client/access/tokenRefresh").permitAll();

        http.authorizeRequests().antMatchers(GET,"/adresse/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/adresse/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/catalogueemballage/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/catalogueemballage/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/catalogueproduit/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/catalogueproduit/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/categorie/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/categorie/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/commande/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/commande/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/emballage/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/emballage/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/lignecommande/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/lignecommande/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/facture/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/facture/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/livraison/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/livraison/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/produit/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/produit/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/produitgros/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/produitgros/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        http.authorizeRequests().antMatchers(GET,"/client/**").hasAnyAuthority("ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");
        http.authorizeRequests().antMatchers(POST,"/client/").hasAnyAuthority("ROLE_ADMIN","ROLE_MANAGER","ROLE_SUPER_USER");

        //http.authorizeRequests().antMatchers("/client/join").permitAll().and().authorizeRequests().antMatchers("/client/**").authenticated().and().httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AuthenticationManager AuthenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
   }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
