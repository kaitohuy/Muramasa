# build.sh
#!/bin/bash
apt-get update
apt-get install -y maven
mvn clean compile exec:java -Dexec.mainClass="main.Main"
