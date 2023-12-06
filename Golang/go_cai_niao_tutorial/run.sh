#!/bin/bash
go build .
ret=$?
if [ $ret eq 0 ] 
./my-go-test
then
    echo "errro code: $ret"
fi
