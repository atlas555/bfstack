#/bin/bash

git pull -r

mvn clean package

cd /app/srv/blog/webapp/
cp /home/atlas/work/git/bfstack/target/bfstack-1.0.war .
unzip -o bfstack-1.0.war
rm bfstack-1.0.war
cd ..
sh ./tomcat/bin/restart.sh ; tail -f tomcat/logs/*
