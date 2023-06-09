#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/select.h>
#include<sys/time.h>
#include<sys/socket.h>
#include<strings.h>
#include<string.h>
#include<arpa/inet.h>
#include<unistd.h>
#include"mynet.h"

int main(){
    
    int sock=socket(AF_INET,SOCK_STREAM,0);
    
    //初始服务端信息：向哪个ip的哪个端口发起连接
    struct sockaddr_in serv_addr;
    socklen_t serv_addr_len=sizeof(serv_addr);
    memset(&serv_addr,0,serv_addr_len);
    serv_addr.sin_family=AF_INET;
    serv_addr.sin_addr.s_addr=inet_addr(IP);
    serv_addr.sin_port=htons(PORT);
    

    connect(sock,(struct sockaddr*)&serv_addr,serv_addr_len);

    char buf[SIZE];
    while (1) {
        memset(buf,0,SIZE);
        printf("请输入：\t");
        fgets(buf,SIZE,stdin);
        write(sock,buf,strlen(buf));
        if(!strncmp(buf,"quit",4)) break;
    }
    
    close(sock);

    return 0;
}
