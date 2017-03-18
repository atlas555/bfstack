#/bin/bash

cd /app/srv/blog/webapp/
cp /home/atlas/work/git/bfstack/target/bfstack-1.0.war .
unzip -o bfstack-1.0.war
rm bfstack-1.0.war
cd ..
sh ./tomcat8/bin/restart.sh ; tail -f tomcat8/logs/*
