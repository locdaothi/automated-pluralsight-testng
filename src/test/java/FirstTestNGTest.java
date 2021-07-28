import baseclasses.UnitTestBaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class FirstTestNGTest extends UnitTestBaseClass {
    // Arrange : need to instantiate the UserManager object
    UserManager userManager;
    @BeforeMethod
    public void localSetupMethod(Method testMethod){
        String decs = testMethod.getAnnotation(Test.class).description();
        System.out.println("Starting test: " + testMethod.getName() + " with description: " + decs );
        userManager = new UserManager();
    }
    @Test(description = "Verify successful add user and return true")
    public void successfulAddUserReturnTrue(){
        //Act : call the addUSer method and save the return value
        boolean result = userManager.addUser("abc@gmail,com");

        //Assert : compare actual and expected values
        Assert.assertTrue(result);

    }
    @Test (description = "Verify get existing user ")
    public void getUserReturnsExistingSavedUser(){

        userManager.addUser("abc@gmail,com");

        //Act
        String user = userManager.getUser("abc@gmail,com");

        //Assert
        Assert.assertEquals(user, "abc@gmail,com");
    }
    @Test
    public void getNonExistingUserReturnsNull(){

        //Act
        String user = userManager.getUser("abc@gmail,com");
        //Assert
        Assert.assertNull(user);
    }


}
