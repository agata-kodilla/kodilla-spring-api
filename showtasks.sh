stop_tomcat()
{
  $CATALINA_HOME/bin/shutdown.sh
}
fail() {
  echo "There were errors"
}
echo 'run runcrud.sh'
 if sh ./runcrud.sh; then
   echo 'run GET /v1/tasks'
/usr/bin/open -a "/Applications/Google Chrome.app" 'http://localhost:8080/crud/v1/tasks'
  else
     fail
  fi
stop_tomcat


stop_tomcat