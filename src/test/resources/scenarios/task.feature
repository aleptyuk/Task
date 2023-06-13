Feature: Check CNP

  Scenario: Input five correct different citizen CNP

    Given Open citizen CNP page
    When Click on CNP input field
    And Enter random correct generated CNP
    And Click check validate CNP
    Then Result message says "1" CNP number was added
    When Click on CNP input field
    And Enter random correct generated CNP
    And Click check validate CNP
    Then Result message says "2" CNP number was added
    When Click on CNP input field
    And Enter random correct generated CNP
    And Click check validate CNP
    Then Result message says "3" CNP number was added
    When Click on CNP input field
    And Enter random correct generated CNP
    And Click check validate CNP
    Then Result message says "4" CNP number was added
    When Click on CNP input field
    And Enter random correct generated CNP
    And Click check validate CNP
    Then Result message about final successful result