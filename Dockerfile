FROM jboss/keycloak:${version.keycloak}

COPY target/*.jar /opt/jboss/keycloak/modules/com/github/patsbin/keycloak-ip-authenticator/provider/main/
COPY target/classes/module.xml /opt/jboss/keycloak/modules/com/github/patsbin/keycloak-ip-authenticator/provider/main/
