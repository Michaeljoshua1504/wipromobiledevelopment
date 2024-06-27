#!/bin/bash

echo "Enter length"
read length
echo "Enter breadth"
read breadth

area=$((length * breadth))
echo "Area: $area units"