package moee.henaknowledge.configuration;

import moee.henaknowledge.Filter.JwtRequestFilter;
import moee.henaknowledge.service.MyUserDetailsService;
import moee.henaknowledge.util.constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/Fake/**").permitAll()
                .antMatchers("/Experience/**").hasAnyRole(constant.TEACHER_ROLE,constant.ADMIN_ROLE,constant.STUDENT_ROLE)
                .antMatchers("/Comment/**").hasAnyRole(constant.TEACHER_ROLE,constant.ADMIN_ROLE,constant.STUDENT_ROLE)
                .antMatchers("/Admin/**").hasRole(constant.ADMIN_ROLE)
                .antMatchers("/Teacher/**").hasAnyRole(constant.TEACHER_ROLE,constant.ADMIN_ROLE,constant.STUDENT_ROLE)
                .antMatchers("/Student/**").hasAnyRole(constant.TEACHER_ROLE,constant.ADMIN_ROLE,constant.STUDENT_ROLE)
                .antMatchers("/Person/**").hasAnyRole(constant.TEACHER_ROLE,constant.ADMIN_ROLE,constant.STUDENT_ROLE)
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web ) throws Exception
    {
        web.ignoring().antMatchers( HttpMethod.OPTIONS, "/**" );
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        var configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
