# spring-security
Authorization + Resource server.


Implemented simple authorization + resource servers using oauth2.

# Authorization server:

- Defines entities, repositories, services for User, Role, Client.
- Stores data in an in memory H2 database.
- Defines UserDetails, UserDetailsService, ClientDetails, ClientDetails service to work with oath.
- Enables the server to work as authorization and resource server and provides necessary config classes to create and register every bean needed
  for desired scope.
- Generates an jwt authentication token that can be used to acces rest endpoints in resource server.
- Provides endpoints to add new user and obtain additional data about a logged user besides what is stored in the token.
- At startup the authorization server adds two roles('ADMIN', 'USER') in the database and an user with username: admin, password:admin, role: ADMIN.
- At startup the authorization server ads a client with clientId: client and clientSecret: secret
- Users can log in by send a POST request at http://localhost:8080/oauth/token?scope=?&grant_type=?&username=?&password=?&Authorization=base64encoded("clientId:secretId")
- Scope can be read or write, grant_type can be password or authorization_code or refresh_token or client_credentials or implicit, username and password 
  can be used the ones from admin user or the ones provided when registering a new user and the Authorization is the encoded base64 of clientId and clientSecret.
- New users can be sending a POST request at localhost:8080/users with a UserDto body. This endpoint can be called by everyone(authenticated or anonymous users).
- Informations about a logged in user can be obtain by sending a GET request at localhost:8080/users/me . This endpoint can be called only by authenticated users.

# Resource server:
- Simple rest endpoint application for managing a stock portofolio.
- Runs on port 9090.
- Provides entities, repositories, services for portofolio and stock.
- Stores data in an in memory H2 database
- Provides controller advices to handle exceptions.
- Every endpoint is secured and can be accesed by providing the access token from the authorization server.
