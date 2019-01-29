Feature: USer should be able to book ticket on the application

Scenario: As a valid user, I must be able to book ticket successfully on Newtours application

Given the user has logged in successfully in the application
When he select flight details from Flight Finder Page
And he select return and departure flight from Select Flight Page
And he enters the mandatory details on Book A Flight Page
Then he must be able to book the ticket successfully