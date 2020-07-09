#!/bin/bash
   PID=$(ps -ef | grep shops-0.0.1-SNAPSHOT.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then

    echo Application is already stopped
else

    echo kill $PID

    kill $PID
fi
   echo starting
   java -jar shops-0.0.1-SNAPSHOT.jar  > log.file 2>log.error &