Feature: UI tests of XM web app - UI task

  Scenario: Check if Economic Calendar slider set dates correctly
    Given Home page is opened
    When I click "Research&Education" main menu link
    And I click "Economic Calendar" link in "Research&Education" submenu
    Then I am redirected to "/research/economicCalendar" url
    When I set "Today" on slider
    Then "Today" date is set correctly
    When I set "Tomorrow" on slider
    Then "Tomorrow" date is set correctly
    When I set "Next Week" on slider
    Then "Next Week" date is set correctly

  Scenario: Check if Educational Video plays correctly
    Given Home page is opened
    When I click "Research&Education" main menu link
    And I click "Educational Videos" link in "Research&Education" submenu
    Then I am redirected to "/educational-videos" url
    When I show "Into The Markets" panel
    And I choose following video lesson "Lesson 1.1"
    Then I can play chosen video for "00:05" seconds