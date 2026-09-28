#!/bin/bash

value1="$1";
value2="$2";

sum_value=$(( value1 + value2 ))
google_fetch_status=$(curl -s --head www.google.com)

echo "$google_fetch_status" | grep -e "HTTP" | sed 's/1.1/curl --head www.google.com/' | sed "s/200/$sum_value/"