//package co.startech.co.quizeonlinesystem;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resources;
//import javax.sql.DataSource;
//
////package co.startech.co.quizeonlinesystem;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.builders.WebSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
////
////import javax.sql.DataSource;
////
//@Configuration
//@EnableWebSecurity
//@EnableAutoConfiguration
//@Component
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    //@Qualifier("bCryptPasswordEncoder")
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    //private ShaPasswordEncoder passwordEncoder=new ShaPasswordEncoder(256);
//
//    @Autowired
//    //@Qualifier("sucessHandler")
//    private CustomLoginSuccessHandler sucessHandler;
//
//    @Autowired
//    private DataSource dataSource;
////
//    @Value("${spring.queries.users-query}")
//    private String usersQuery;
////
//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
//                .dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                // URL matching for accessibility
//                .antMatchers("/").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers(
//                        "/registration**",
//                        "/js/**",
//                        "/css/**",
//                        "/img/**").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/home/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
//                .antMatchers("/admin/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER")
//                .anyRequest().authenticated()
//                .and()
//                // form login
//                .csrf().disable().formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error=true")
//                .successHandler(sucessHandler)
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and()
//                // logout
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/access-denied");
//    }
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
////    }
//
//}
