#include<stdio.h>
#include<sys/types.h>
#include<stdlib.h>
#include<sys/socket.h>
#include<string.h>
#include<arpa/inet.h>
#include<netinet/in.h>
#include<unistd.h>

int main(int argc,char* argv[]) {

    int sock;
    sock= socket(AF_INET,SOCK_DGRAM,0);

    struct sockaddr_in dest_addr;
    memset(&dest_addr,0,sizeof(dest_addr));
    socklen_t dest_addr_len=sizeof(dest_addr);
    
    dest_addr.sin_family=AF_INET;
    dest_addr.sin_addr.s_addr=inet_addr("127.0.0.1");
    dest_addr.sin_port=htons(1234);



    char buf[128];

    char *msg="我是客户端";

    int i=13243;
    while (1) {
        printf("服务器地址：%s   counter: %d\n",inet_ntoa(dest_addr.sin_addr),i);

        sendto(sock,msg,strlen(msg),0,(struct sockaddr*)&dest_addr,dest_addr_len);//向dest send

        struct sockaddr_in src_addr;
        memset(&src_addr,0,sizeof(src_addr));
        socklen_t src_addr_len=sizeof(src_addr);

        memset(buf,0,sizeof(buf));
        recvfrom(sock,buf,sizeof(buf)-1,0,(struct sockaddr*)&src_addr,&src_addr_len); //从src中recv 
        printf("服务器发送的消息：%s   counter: %d\n",buf,i++);
        
        sleep(2);  
    }
    close(sock);
    return 0;
}