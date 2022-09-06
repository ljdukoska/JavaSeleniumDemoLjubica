Feature: Adding to Cart

  Scenario Outline: Adding products to cart
    * I am on Sauce Demo Login Page
    * I enter username "<username>"
    * I enter password "<password>"
    * I click login button
    * I add a product "<productName>"
    * I verify cart number icon "<productsNum>"

    Examples:
      | username      | password     | productName         | productsNum |
      | standard_user | secret_sauce | Sauce Labs BackPack | 1           |