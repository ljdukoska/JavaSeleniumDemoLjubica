Feature: CheckOut page

  @Scenario1
  Scenario Outline: Click Cancel button on CheckOut page
    * I am on Sauce Demo Login Page
    * I enter username "<username>"
    * I enter password "<password>"
    * I click login button
    * I add a product "<productName>"
    * I verify cart number icon "<productsNum>"
    * I click cart button
    * I should be on Cart page
    * I click CheckOut button
    * I should be on CheckOut page
    * I click Cancel button
    * I should be on Cart page


    Examples:
      | username      | password     | productName         | productsNum |
      | standard_user | secret_sauce | Sauce Labs BackPack | 1           |

  @Scenario2
  Scenario Outline: Click Continue button on CheckOut page
    * I am on Sauce Demo Login Page
    * I enter username "<username>"
    * I enter password "<password>"
    * I click login button
    * I add a product "<productName>"
    * I click cart button
    * I should be on Cart page
    * I click CheckOut button
    * I should be on CheckOut page
    * I enter First Name "<firstname>"
    * I enter Last Name "<lastname>"
    * I enter Postal Code "<postalcode>"
    * I click Continue button
    * I should be on CheckOut Overview page


    Examples:
      | username      | password     | productName         | firstname | lastname | postalcode |
      | standard_user | secret_sauce | Sauce Labs BackPack | Ljubica   | Dukoska  | 6530       |