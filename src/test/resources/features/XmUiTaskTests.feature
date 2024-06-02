Feature: UI tests of XM app - UI task

Scenario: Check if Economic Calendar slider set dates correctly
  Given Home page is opened
  And All cookies are accepted
  When I click "Research&Education" main menu link
  And I click "Economic Calendar" link in "Research&Education" submenu
  And I set "Today" on slider
  Then "Today" date is set correctly
  When I set "Tomorrow" on slider
  Then "Tomorrow" date is set correctly
  When I set "Next Week" on slider
  Then "Next Week" date is set correctly

  Scenario: Check if Educational Video plays correctly
    Given Home page is opened
    When I click "Research&Education" main menu link
    And I click "Educational Videos" link in "Research&Education" submenu
    And I show "Into The Markets" panel
    And I choose following video lesson "Lesson 1.1"
    Then I can play chosen video for at least "00:05"