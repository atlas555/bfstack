#/bin/bash

source /etc/profile

echo "---- start pull code from github ---"
sleep 1

git pull -r

echo "--- start package war from source ---"
sleep 1
mvn clean package

echo "--- start deploy war to tomcat ---"
sleep 1
cd /app/srv/blog/webapp/
cp /home/atlas/work/git/bfstack/target/bfstack-1.0.war .
unzip -o bfstack-1.0.war
rm bfstack-1.0.war
cd ..
sh ./tomcat8/bin/restart.sh ; tail -f tomcat8/logs/*
