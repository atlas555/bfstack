#/bin/bash

git pull -r

mvn clean package

cd /app/srv/blog/webapp/
cp /home/atlas/work/git/bfstack/target/bfstack.war .
unzip -o bfstack.war
rm bfstack.war
cd ..
sh ./tomcat/bin/restart.sh ; tail -f tomcat/logs/*
