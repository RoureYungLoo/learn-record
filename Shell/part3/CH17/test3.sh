#!/bin/bash

function func1(){
    echo "This is the FIRST definition of the function name" 
}
func1
function func1(){
    echo "This is a REPEAT of the same function name"
}
func1

echo "This is the END of the script"