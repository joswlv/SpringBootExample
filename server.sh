#!/bin/bash
JARFile="jinhoTest.war"

function start {
    if pkill -0 -f $JARFile > /dev/null 2>&1
    then echo "Service [$JARFile] is already running. Ignoring startup request/"
      exit 1
    fi
    echo "Staring [$JARFile] Application!!"
    nohup java -server -Xms2G -Xmx2G -jar $JARFile --server.port=8080 >/dev/null 2>&1 &

}

function stop {
    if ! pkill -0 -f $JARFile > /dev/null 2>&1
    then
        echo "Service [$JARFile] is not running. Ignoring shutdown request."
        return 0
    fi

    echo "Stopping [$JARFile]!!"

    # First, we will try to trigger a controlled shutdown using
    # spring-boot-actuator
    # Wait until the server process has shut down
    attempts=0
    while pkill -0 -f $JARFile > /dev/null 2>&1
    do
        attempts=$[$attempts + 1]
        if [ $attempts -gt 5 ]
        then
            # We have waited too long. Kill it.
            pkill -f $JARFile > /dev/null 2>&1
        fi
        sleep 1s
    done
    echo "Stop [$JARFile] is completed!!"
}

function status {
    if pkill -0 -f $JARFile > /dev/null 2>&1
    then echo "Service [$JARFile] is running."
      exit 1
    fi
    echo "Service [$JARFile] is not running"
}

case "$1" in
  status)
    status
    ;;
  stop)
        stop
    ;;
  start)
        start
    ;;
  restart)
    stop
    start
    ;;
  *)
    echo "Usage: $0 {start|stop|restart|status}"
    exit 1
esac

exit 0