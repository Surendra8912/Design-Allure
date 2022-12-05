package Step;

import DemopetShop.Petshop;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyStepdefs {
    Petshop web = new Petshop();
    @Given("open url of the webshop")
    public void openUrlOfTheWebshop() {
        web.Main();
    }

    @And("Login to Demowebshop")
    public void loginToDemowebshop() throws InterruptedException{
      web.Login();
      web.Elements();
      web.Checkbox();
      web.Radio();
      web.Webtables();
      web.Buttons();
      web.Links();

    }

    @Then("Book Shop is Functionable")
    public void bookShopIsFunctionable() throws InterruptedException {
        web.Upload();

    }
}
