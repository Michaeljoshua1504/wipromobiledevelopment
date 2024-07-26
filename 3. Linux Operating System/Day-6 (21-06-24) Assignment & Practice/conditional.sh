#!/bin/bash

time=$(date +%H)
echo "time: $time"
if [ $time -lt 12 ]; then
    echo "Good morning user!"
elif [ $time -lt 18 ]; then
    echo "Good afternoon user!"
else 
    echo "Good evening user"
fi
echo "Program terminated"