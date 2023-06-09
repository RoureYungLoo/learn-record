#include<stdio.h>
#include<sys/types.h>
#include<stdlib.h>
#include<sys/socket.h>
#include<string.h>
#include<arpa/inet.h>
#include<netinet/in.h>
#include<unistd.h>

int main(int argc,char * argv[]){
    int udp_sock;


    udp_sock= socket(AF_INET,SOCK_DGRAM,IPPROTO_UDP);
    struct sockaddr_in local_addr;
    memset(&local_addr,0,sizeof(local_addr));

    local_addr.sin_family=AF_INET;
    local_addr.sin_addr.s_addr=inet_addr("127.0.0.1");
    local_addr.sin_port=htons(1234);

    socklen_t local_addr_len=sizeof(local_addr);

    bind(udp_sock,(struct  sockaddr*)&local_addr,local_addr_len);

    int i=42343;
    char *msg="我是服务器";
    char buf[128];


    while (1){
        memset(buf,0,sizeof(buf));

        struct sockaddr_in src_addr;
        memset(&src_addr,0,sizeof(src_addr));
        socklen_t src_addr_len=sizeof(src_addr);

        recvfrom(udp_sock,buf,sizeof(buf)-1,0,(struct sockaddr*)&src_addr,&src_addr_len);////从src中recv
        printf("客户端发送的消息：%s  counts: %d\n",buf,i++);
        sleep(2);        

        printf("客户端地址：%s  counts: %d\n",inet_ntoa(src_addr.sin_addr),i);
        sendto(udp_sock,msg,strlen(msg),0,(struct sockaddr*)&src_addr,src_addr_len);//向src send

    }
    close(udp_sock);
    return 0;
}