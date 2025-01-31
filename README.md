# Mock Bank Application Spring

This is a project for the MOOC Web-palvelinohjelmointi Java from University of Helsinki.  
Learning purposes: Spring Boot, Spring Security, Spring MVC, Spring Web, Spring JPA, MySQL integration.

## Functionalities implemented in the project:

### User Authentication and Authorization:
- Users can register and log in securely.
- Spring Security for authentication and role-based access control.
- Passwords encrypted using BCrypt.

### Account Management:
- Users can create and manage bank accounts.
- Each account has an account number, balance, and linked user.
- Users can view their account details and balance.

### Fund Transfers:
- Users can transfer funds between accounts.
- Validate transactions.

### Transaction History:
- Record transaction history.
- Users can view their transaction history with filters (e.g., by date, transaction type).

### Database:
- MySQL using Spring Data JPA for database interactions.

## Further Implementation and fixes:
- Tests using Junit or Mockito
- Jwt authentication
- Oauth2 authentication
- Proper error handling
- Minor bugs


