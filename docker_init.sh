mvn install
mvn package docker:build
#docker network rm opc_ua_data_network
docker image prune
docker rm -f opc-ua-data-mongodb
docker rm -f opc-ua-data-rest
#docker network create --subnet=172.28.0.0/16 --ip-range=172.28.5.0/24 --gateway=172.28.5.254 opc_ua_data_network
docker create --name opc-ua-data-mongodb -p 27017:27017 -t mongo
docker create --name opc-ua-data-rest -p 8080:8080 -t harha/opc_ua_data_rest -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n"