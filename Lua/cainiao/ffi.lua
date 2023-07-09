#!/usr/local/openresty/bin/resty

local ffi=require "ffi"
local ffi_null=ffi.null
local ffi_cdef = ffi.cdef
local ffi_new = ffi.new
local ffi_C = ffi.C

ffi_cdef[[
	struct timeval{
		long int tv_sec;
		long int tv_usec;
	};
	int gettimeofday(struct timeval *tv,void *tz);
]]

local timeval_t=ffi.typeof("struct timeval")
local tm=ffi_new(timeval_t)

ffi_C.gettimeofday(tm,ffi_null) 

print(type(tm.tv_sec))
print(tm.tv_sec)
print(tonumber(tm.tv_sec))