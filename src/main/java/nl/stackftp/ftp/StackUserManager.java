package nl.stackftp.ftp;

import org.apache.ftpserver.ftplet.*;
import org.apache.ftpserver.usermanager.UsernamePasswordAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StackUserManager implements UserManager {

    /**
     * The user service.
     */
    @Autowired
    protected UserService userService;

    /**
     * Get an user by name.
     *
     * @param name The user name.
     * @return Always null because there are no real users.
     */
    public User getUserByName(String name) throws FtpException {
        return null;
    }

    /**
     * Get a list of all user names.
     *
     * @throws FtpException Always thrown because there are no real users.
     */
    public String[] getAllUserNames() throws FtpException {
        throw new FtpException("No ftp users");
    }

    /**
     * Delete an user.
     *
     * @param name The user name
     * @throws FtpException Always thrown because there are no real users.
     */
    public void delete(String name) throws FtpException {
        throw new FtpException("Can't delete user");
    }

    /**
     * Save an user.
     *
     * @param name The user name.
     * @throws FtpException Always thrown because there are no real users.
     */
    public void save(User name) throws FtpException {
        throw new FtpException("Can't save user");
    }

    /**
     * Does an user exists?
     * Always true because this can't be checked.
     *
     * @param name The user name.
     * @return Always true.
     */
    public boolean doesExist(String name) throws FtpException {
        return true;
    }

    /**
     * Authenticate an user by name and password.
     *
     * @param authentication The name and password.
     * @return The user when credentials are correct.
     * @throws AuthenticationFailedException Thrown when credentials are wrong or Webdav server connection failed.
     */
    public User authenticate(Authentication authentication) throws AuthenticationFailedException {
        try {
            // Cast the object so the username and password are readable.
            UsernamePasswordAuthentication userAuthentication = (UsernamePasswordAuthentication) authentication;

            return this.userService.authenticate(userAuthentication.getUsername(), userAuthentication.getPassword());
        } catch (ClassCastException ex) {
            throw new AuthenticationFailedException("Please provide a username and password");
        } catch (FtpException ex) {
            throw new AuthenticationFailedException(ex.getMessage());
        }
    }

    /**
     * Get the admin name.
     *
     * @throws FtpException Always thrown because there is no admin.
     */
    public String getAdminName() throws FtpException {
        throw new FtpException("No server admin");
    }

    /**
     * Check if an user is admin.
     *
     * @param name The user name.
     * @return True when admin.
     * @throws FtpException Thrown on error.
     */
    public boolean isAdmin(String name) throws FtpException {
        return false;
    }
}
