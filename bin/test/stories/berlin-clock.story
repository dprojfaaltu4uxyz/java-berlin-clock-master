Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: Invalid Time
When the time is abcdasdad
Then the clock should look like
Invalid time

Scenario: Hours greater than 24
When the time is 25:00:00
Then the clock should look like
Hours out of bound

Scenario: Hours greater than 24
When the time is 22:60:00
Then the clock should look like
Minutes out of bound

Scenario: Hours greater than 24
When the time is 22:20:60
Then the clock should look like
Seconds out of bound



