#!/bin/bash

openresty -p `pwd` -c `pwd`/conf/nginx.conf -s stop
sleep 1
openresty -p `pwd` -c `pwd`/conf/nginx.conf
