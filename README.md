# Keycloak Conditional HTTP Header Authenticator

Check the http request header to match on a regex string.

Initial code by Sebastian Preisner, copied from https://github.com/keycloak/keycloak/pull/14605.

Relevant Keycloak Documentation part: https://www.keycloak.org/docs/latest/server_admin/#conditions-in-conditional-flows

### Build

Use with Maven (>3) and JDK (>= 17).

```
mvn clean verify
```

Copy deployments/conditional-http-header-authenticator-jar-with-dependencies.jar to /providers/ directory in Keycloak.

### Example

See https://github.com/elexis/keycloak-auth-deny-user-nosecondfactor for a usage example.