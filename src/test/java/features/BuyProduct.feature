Feature: Adding to Cart

  @Scenario1
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

  @Scenario2
  Scenario Outline: See cart page
    * I am on Sauce Demo Login Page
    * I enter username "<username>"
    * I enter password "<password>"
    * I click login button
    * I add a product "<productName>"
    * I verify cart number icon "<productsNum>"
    * I click cart button
    * I should be on Cart page

    Examples:
      | username      | password     | productName         | productsNum |
      | standard_user | secret_sauce | Sauce Labs BackPack | 1           |