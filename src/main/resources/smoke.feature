Feature:


  Scenario Outline: Main functions test
    Given User opens '<homePage>' page
    And User checks cart visibility
    And User checks wishlist visibility
    And User checks my Account visibility
    And User checks search field visibility
    And User checks country selector button visibility
    And User checks men button visibility
    And User checks women button visibility
    When User clicks '<menOrWomen>' button button
    Then User checks that url contains '<menOrWomen>'

    Examples:
      | homePage              | menOrWomen |
      | https://www.asos.com/ | women      |

  Scenario Outline: Registration negative test
    Given User opens '<homePage>' page
    And User clicks my Account button
    And User clicks SignUp button
    And User enters '<incorrectEmail>'
    And User enters '<firstName>' in first name field
    And User enters '<lastName>' in last name field
    And User enters '<incorrectPassword>' in password field
    When User clicks on register button
    Then User checks email and password errors visibility

    Examples:
      | homePage              | firstName | lastName | incorrectPassword   | incorrectEmail |
      | https://www.asos.com/ | Bill      | Carpenter| qwerty              | qwerty         |

  Scenario Outline: Check add to wishlist
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks wishlist button
    And User opens wishlist page
    Then User checks that wishlist contains 1 product

      Examples:
      | homePage               | keyword  |
      | https://www.asos.com/  | backpack |

  Scenario Outline: Check add to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks Add to Bag button
    And User clicks Cart button
    And User checks Checkout button visibility
    And User checks View Bag button visibility
    And User clicks View Bag button
    Then User checks that cart contains cart item
    And User checks that cart icon contains 1

      Examples:
        | homePage                | keyword                                  |
        | https://www.asos.com/   | Casio A168WA-1YES Digital Bracelet Watch |

  Scenario Outline: Product page test
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User checks product title visibility
    And User checks image visibility
    And User checks price visibility
    And User checks Add to Bag button visibility
    And User checks wishlist button visibility
    And User clicks Show More button
    And User checks product details visibility
    And User clicks reviews button
    And User checks reviews window visibility
    And User clicks close reviews button
    And User clicks Add to Bag button
    Then User checks that cart popup header contains 1 item

      Examples:
        | homePage                | keyword                                    |
        | https://www.asos.com/   | Casio A168WA-1YES Digital Bracelet Watch   |

    Scenario Outline: Sign In test
      Given User opens '<homePage>' page
      And User clicks my Account button
      And User clicks SignIn button
      And User checks email input visibility
      And User fills in email input with '<email>'
      And User checks password input visibility
      And User fills in password input with'<password>'
      When User clicks on sign in button
      Then User checks myAccount popup contains sign out button

      Examples:
        | homePage              |  email                      | password   |
        | https://www.asos.com/ |  john.smith+1234@gmail.com  | qwertyuiop |

    Scenario Outline: Sign in negative test
      Given User opens '<homePage>' page
      And User checks my Account visibility
      And User clicks my Account button
      And User clicks SignIn button
      And User checks email input visibility
      And User fills in email input with '<incorrectEmail>'
      And User checks password input visibility
      And User fills in password input with'<incorrectPassword>'
      When User clicks on sign in button
      Then User checks email error visibility

        Examples:
          | homePage              |  incorrectPassword   | incorrectEmail |
          | https://www.asos.com/ |  qwerty              | qwerty         |

    Scenario Outline: Change currency test
      Given User opens '<homePage>' page
      And User checks search field visibility
      And User makes search by '<keyword>'
      And User checks price visibility
      And User clicks preferences button
      And User checks country selector visibility
      And User checks currency selector visibility
      When User selects '<currency>'
      And clicks update preferences button
      Then User checks that price contains '<currencySymbol>'

        Examples:
          | homePage            | keyword   | currency | currencySymbol |
          |https://www.asos.com/| 105533791 | £ GBP    | £              |

    Scenario Outline: Marketplace main functions test
      Given User opens '<homePage>' page
      And User checks market place button visibility
      When User clicks marketplace button
      Then User checks that url contains marketplace
      And User checks account icon visibility
      And User checks wishlist icon visibility
      And User checks cart icon visibility
      And User checks search box visibility
      And User checks settings button visibility
      And User checks site selections visibility
      And User checks categories visibility

      Examples:
        | homePage            |
        |https://www.asos.com/|

    Scenario Outline: Search results amount test
      Given User opens '<homePage>' page
      And User checks search field visibility
      And User makes search by '<keyword>'
      And User checks search results amount is <searchResultsAmount>
      When User clicks Load More
      Then User checks loaded search results amount is <loadMoreAmount>

        Examples:
          | homePage              | keyword  |  searchResultsAmount | loadMoreAmount |
          | https://www.asos.com/ | backpack |          72          |       144      |

