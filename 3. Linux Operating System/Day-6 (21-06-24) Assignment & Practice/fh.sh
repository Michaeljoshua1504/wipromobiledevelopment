#!/bin/bash
read -p "Enter the file name: " filename
while read line 
do
echo $line
done < $filename