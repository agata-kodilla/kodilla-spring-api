#!/usr/bin/env bash

export CATALINA_HOME=/Library/Tomcat

stop_tomcat()
{
  $CATALINA_HOME/bin/shutdown.sh
}

start_tomcat()
{
  $CATALINA_HOME/bin/startup.sh
}

rename() {
  rm build/libs/crud.war
  if mv build/libs/kodilla-spring-api-0.0.1-SNAPSHOT.war build/libs/crud.war; then
     echo "Successfully renamed file"
  else
     echo "Cannot rename file"
     fail
  fi
}

copy_file() {
  if cp build/libs/crud.war $CATALINA_HOME/webapps; then
    echo "start tomcat"
     start_tomcat
  else
     fail
  fi
}

fail() {
  echo "There were errors"
}

end() {
  echo "Work is finished"
}

if ./gradlew build; then
   rename
   copy_file
else
  echo "stop tomcat"
   stop_tomcat
   fail
fi