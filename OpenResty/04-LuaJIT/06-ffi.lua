#!/usr/local/openresty/luajit/bin/luajit
print('ok')
--ffi
local ffi=require 'ffi'

local ffi_load = ffi.load
local ffi_cdef = ffi.cdef
local ffi_typeof = ffi.typeof
local ffi_new = ffi.new
local ffi_C = ffi.C
local ffi_null = ffi.null
local ffi_alignof = ffi.alignof
local ffi_sizeof = ffi.sizeof
local ffi_offsetof = ffi.offsetof
local ffi_copy = ffi.copy
local ffi_fill = ffi.fill
local ffi_errno = ffi.errno
local ffi_string = ffi.string
local ffi_os = ffi.os
local ffi_arch = ffi.arch

ffi_cdef[[
    struct dummy {};
    double sqrt(double x);
    int gethostname(char* name,size_t len);
    struct timeval {
        long int tv_sec;
        long int tv_usec;
    };
    int gettimeofday(struct timeval *vt,void *tz);
]]

local int_t=ffi_typeof("int")
local char_arr_t=ffi_typeof("char[?]")

local a_int=ffi_new(int_t)
local char_arr=char_arr_t(10)

local timeval_t=ffi_typeof("struct timeval")
local tm=ffi_new(timeval_t)

ffi_C.gettimeofday(tm,ffi_null)

print(type(tm.tv_sec))
print(tm.tv_sec)
print(tonumber(tm.tv_sec))

-- http://wiki.luajit.org/NYI


