package Resources;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "wrong credentials")
    public Object[][] getWrongCredentialsFromProvider() {
        return new Object[][] {
                {"nenchon@gmail.com", "wrongPassword"},
                {"nenchon@gmail.com", ""},
                {"wrongEmail", "P@swword1"},
                {"", "P@swword1"},
                {"", ""}
        };
    }

    @DataProvider(name = "credentials")
    public Object[][] getCredentialsFromProvider() {
        return new Object[][] {
                {"nenchon@gmail.com", "P@swword1"}
        };
    }
}
