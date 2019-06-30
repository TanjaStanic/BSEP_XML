@echo off
set /p commonName="Enter common name for all certificates(localhost): "

IF EXIST eureka.jks DEL /F eureka.jks
IF EXIST zuul.jks DEL /F zuul.jks
IF EXIST admin.jks DEL /F admin.jks
IF EXIST auth.jks DEL /F auth.jks
IF EXIST reservation.jks DEL /F reservation.jks
IF EXIST agent.jks DEL /F agent.jks
IF EXIST eureka.crt DEL /F eureka.crt
IF EXIST zuul.crt DEL /F zuul.crt
IF EXIST admin.crt DEL /F admin.crt
IF EXIST auth.crt DEL /F auth.crt
IF EXIST reservation.crt DEL /F reservation.crt
IF EXIST agent.crt DEL /F agent.crt

echo Generating keystores...

keytool -genkey -dname "CN=%commonName%, OU=I, O=I, L=T, ST=On, C=CA" -alias eureka -validity 3650 -keyalg RSA -keystore eureka.jks -keypass password -storepass password

keytool -genkey -dname "CN=%commonName%, OU=I, O=I, L=T, ST=On, C=CA" -alias zuul -validity 3650 -keyalg RSA -keystore zuul.jks -keypass password -storepass password

keytool -genkey -dname "CN=%commonName%, OU=I, O=I, L=T, ST=On, C=CA" -alias admin -validity 3650 -keyalg RSA -keystore admin.jks -keypass password -storepass password

keytool -genkey -dname "CN=%commonName%, OU=I, O=I, L=T, ST=On, C=CA" -alias auth -validity 3650 -keyalg RSA -keystore auth.jks -keypass password -storepass password

keytool -genkey -dname "CN=%commonName%, OU=I, O=I, L=T, ST=On, C=CA" -alias reservation -validity 3650 -keyalg RSA -keystore reservation.jks -keypass password -storepass password

keytool -genkey -dname "CN=%commonName%, OU=I, O=I, L=T, ST=On, C=CA" -alias agent -validity 3650 -keyalg RSA -keystore agent.jks -keypass password -storepass password

echo Distributing and importing...

keytool -export -keystore eureka.jks -alias eureka -file eureka.crt -storepass password
keytool -importcert -file eureka.crt -alias eureka -keystore zuul.jks -storepass password -noprompt
keytool -importcert -file eureka.crt -alias eureka -keystore admin.jks -storepass password -noprompt
keytool -importcert -file eureka.crt -alias eureka -keystore auth.jks -storepass password -noprompt
keytool -importcert -file eureka.crt -alias eureka -keystore reservation.jks -storepass password -noprompt
keytool -importcert -file eureka.crt -alias eureka -keystore agent.jks -storepass password -noprompt

keytool -export -keystore zuul.jks -alias zuul -file zuul.crt -storepass password
keytool -importcert -file zuul.crt -alias zuul -keystore eureka.jks -storepass password -noprompt
keytool -importcert -file zuul.crt -alias zuul -keystore admin.jks -storepass password -noprompt
keytool -importcert -file zuul.crt -alias zuul -keystore auth.jks -storepass password -noprompt
keytool -importcert -file zuul.crt -alias zuul -keystore reservation.jks -storepass password -noprompt
keytool -importcert -file zuul.crt -alias zuul -keystore agent.jks -storepass password -noprompt

keytool -export -keystore admin.jks -alias admin -file admin.crt -storepass password
keytool -importcert -file admin.crt -alias admin -keystore eureka.jks -storepass password -noprompt
keytool -importcert -file admin.crt -alias admin -keystore zuul.jks -storepass password -noprompt
keytool -importcert -file admin.crt -alias admin -keystore auth.jks -storepass password -noprompt
keytool -importcert -file admin.crt -alias admin -keystore reservation.jks -storepass password -noprompt
keytool -importcert -file admin.crt -alias admin -keystore agent.jks -storepass password -noprompt

keytool -export -keystore auth.jks -alias auth -file auth.crt -storepass password
keytool -importcert -file auth.crt -alias auth -keystore eureka.jks -storepass password -noprompt
keytool -importcert -file auth.crt -alias auth -keystore zuul.jks -storepass password -noprompt
keytool -importcert -file auth.crt -alias auth -keystore admin.jks -storepass password -noprompt
keytool -importcert -file auth.crt -alias auth -keystore reservation.jks -storepass password -noprompt
keytool -importcert -file auth.crt -alias auth -keystore agent.jks -storepass password -noprompt

keytool -export -keystore reservation.jks -alias reservation -file reservation.crt -storepass password
keytool -importcert -file reservation.crt -alias reservation -keystore eureka.jks -storepass password -noprompt
keytool -importcert -file reservation.crt -alias reservation -keystore zuul.jks -storepass password -noprompt
keytool -importcert -file reservation.crt -alias reservation -keystore admin.jks -storepass password -noprompt
keytool -importcert -file reservation.crt -alias reservation -keystore auth.jks -storepass password -noprompt
keytool -importcert -file reservation.crt -alias reservation -keystore agent.jks -storepass password -noprompt

keytool -export -keystore agent.jks -alias agent -file agent.crt -storepass password
keytool -importcert -file agent.crt -alias agent -keystore eureka.jks -storepass password -noprompt
keytool -importcert -file agent.crt -alias agent -keystore zuul.jks -storepass password -noprompt
keytool -importcert -file agent.crt -alias agent -keystore admin.jks -storepass password -noprompt
keytool -importcert -file agent.crt -alias agent -keystore auth.jks -storepass password -noprompt
keytool -importcert -file agent.crt -alias agent -keystore reservation.jks -storepass password -noprompt

copy admin.jks AdminService\src\main\resources
copy reservation.jks ReservationService\src\main\resources
copy auth.jks MegaTravel\src\main\resources
copy eureka.jks EurekaService\src\main\resources
copy zuul.jks zuul-service\src\main\resources
copy agent.jks AgentMegaTravel\src\main\resources

IF EXIST eureka.jks DEL /F eureka.jks
IF EXIST auth.jks DEL /F auth.jks
IF EXIST zuul.jks DEL /F zuul.jks
IF EXIST admin.jks DEL /F admin.jks
IF EXIST reservation.jks DEL /F reservation.jks
IF EXIST agent.jks DEL /F agent.jks
IF EXIST eureka.crt DEL /F eureka.crt
IF EXIST zuul.crt DEL /F zuul.crt
IF EXIST auth.crt DEL /F auth.crt
IF EXIST admin.crt DEL /F admin.crt
IF EXIST reservation.crt DEL /F reservation.crt
IF EXIST agent.crt DEL /F agent.crt
