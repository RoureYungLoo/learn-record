#!/bin/bash

openresty -p `pwd` -c `pwd`/conf/nginx.conf -s stop
openresty -p `pwd` -c `pwd`/conf/nginx.conf