package atc.example.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration
      extends WebSecurityConfigurerAdapter
{
    @Autowired
    public void configureGlobal1 ( final AuthenticationManagerBuilder auth ) throws Exception
    {
        // Allow for users that are logged in to go anywhere
        auth.inMemoryAuthentication();
    }


    @Override
    protected void configure ( final HttpSecurity http ) throws Exception
    {
        http.httpBasic()
              .disable()
              .authorizeRequests()
              .antMatchers( HttpMethod.GET, "/service-instances/*" ).permitAll()
              .anyRequest().authenticated()
              .and()
              .csrf()
              .disable();
    }
}