package id.co.myapplication.data;

import com.orhanobut.hawk.Hawk;

import id.co.myapplication.data.model.LoggedInUser;
import id.co.myapplication.model.Login;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        if (username.equalsIgnoreCase("fazil.muammar@gmail.com") && password.equalsIgnoreCase("123456")) {
            try {
                // TODO: handle loggedInUser authentication
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "Fazil");
                Hawk.put("user", new Login(username, password));
                return new Result.Success<>(fakeUser);
            } catch (Exception e) {
                return new Result.Error(new IOException("Error logging in", e));
            }
        } else {
            return new Result.Error(new IOException("Error logging in"));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}