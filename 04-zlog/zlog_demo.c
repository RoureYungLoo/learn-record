#include <stdio.h>

#include "zlog.h"

// int main(int argc, char **argv){
//     int rc;
//     zlog_category_t *c;
//     rc = zlog_init("test_hello.conf");
//     if (rc)    {

//         printf("init failed\n");
//         return -1;
//     }

//     c = zlog_get_category("my_cat");
//     if (!c)    {

//         printf("get cat fail\n");

//         zlog_fini();
//         return -2;
//     }

//     // ZLOG_LEVEL_DEBUG = 20,
//     // ZLOG_LEVEL_INFO = 40,
//     // ZLOG_LEVEL_NOTICE = 60,
//     // ZLOG_LEVEL_WARN = 80,
//     // ZLOG_LEVEL_ERROR = 100,
//     // ZLOG_LEVEL_FATAL = 120
//     zlog_info(c, "hello, zlog");
//     zlog_warn(c, "warn log");
//     zlog_debug(c, "debug log");
//     zlog_error(c, "error_log");
//     zlog_fatal(c, "fatal error");
//     zlog_fini();

//     return 0;
// }
// int main(int argc, char **argv)
// {
//     int rc;
//     rc = dzlog_init("test_default.conf", "my_cat");
//     if (rc)
//     {

//         printf("init failed\n");
//         return -1;
//     }

//     dzlog_info("hello, zlog");
//     dzlog_warn("warn log");
//     dzlog_debug( "debug log");
//     dzlog_error( "error_log");
//     dzlog_fatal( "fatal error");

//     zlog_fini();

//     return 0;
// }

int main(int argc, char **argv){
    int rc;
    rc = zlog_init("test_default.conf");
    if (rc)    {

        printf("init failed\n");
        return -1;
    }

    zlog_category_t *c1 = zlog_get_category("my_cat");
    zlog_category_t *c2 = zlog_get_category("my_dot");
    zlog_category_t *c3 = zlog_get_category("ym_clas");
    zlog_category_t *c4 = zlog_get_category("my_test");
    if (c1&&c2&&c3&&c4)    {
        printf("get cat success\n");
        // zlog_fini();
        // return -2;
    }

    // ZLOG_LEVEL_DEBUG = 20,
    // ZLOG_LEVEL_INFO = 40,
    // ZLOG_LEVEL_NOTICE = 60,
    // ZLOG_LEVEL_WARN = 80,
    // ZLOG_LEVEL_ERROR = 100,
    // ZLOG_LEVEL_FATAL = 120

    zlog_error(c1, "c1 error_log");
    zlog_error(c2, "c2 error_log");
    zlog_error(c3, "c3 error_log");
    zlog_error(c4, "c4 error_log");

    zlog_fini();

    return 0;
}

//zlog 日志级别

typedef enum {
	ZLOG_LEVEL_DEBUG = 20,
	ZLOG_LEVEL_INFO = 40,
	ZLOG_LEVEL_NOTICE = 60,
	ZLOG_LEVEL_WARN = 80,
	ZLOG_LEVEL_ERROR = 100,
	ZLOG_LEVEL_FATAL = 120
} zlog_level; 