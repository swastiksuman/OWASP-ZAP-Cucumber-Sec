Feature: Login
	Scenario: Login Security Scan
		Given the user is in home page
		When the user navigates to the Login Page
		Then the security scan should run