Feature: SauceDemo Login


  @Scenario1
  Scenario Outline: I log in to Sauce Demo with valid credentials in row "<row>"
   * I entered test data in Excel "<file>" "<sheet>" "<row>"
   * I am on Sauce Demo Login Page
   * I enter username
   * I enter password
   * I click login button
   * I should be on Inventory page

    Examples:
      | file      | sheet | row |
      | SauceDemo | Data  | 0   |
      | SauceDemo | Data  | 1   |
      | SauceDemo | Data  | 2   |

  @Scenario2
  Scenario Outline: I log in to Sauce Demo with invalid credentials in row "<row>"
    * I entered test data in Excel "<file>" "<sheet>" "<row>"
    * I am on Sauce Demo Login Page
    * I enter username
    * I enter password
    * I click login button
    * I should see an error message on login

    Examples:
      | file      | sheet | row |
      | SauceDemo | Data2 | 0   |
