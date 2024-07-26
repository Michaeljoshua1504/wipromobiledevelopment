#!/bin/bash

echo Enter the file name
read file
c=`cat $file | wc -c`
w=`cat $file | wc -w`
lines=`grep -c "." $file`
echo number of characters in $file is $c
echo number of words in $file is $w
echo number of lines in $file is $lines