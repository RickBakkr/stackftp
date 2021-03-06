package nl.stackftp.configuration;

import nl.stackftp.ftp.StackUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

    /**
     * Create a spring managed instance of StackUser.
     *
     * @param username The username.
     * @param password The user password.
     * @return A StackUser object.
     */
    @Bean
    @Scope("prototype")
    public StackUser stackUser(String username, String password) {
        return new StackUser(username, password);
    }
}
