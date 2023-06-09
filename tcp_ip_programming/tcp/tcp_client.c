#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<arpa/inet.h>
#include<sys/socket.h>
int main(int argc, char const *argv[]) {
    

    int sock;
    struct sockaddr_in server_addr;
    memset(&server_addr,0,sizeof(server_addr));

    server_addr.sin_family=AF_INET;
    server_addr.sin_addr.s_addr=inet_addr("127.0.0.1");//注意调用inet_addr
    server_addr.sin_port=htons(3559);   //htons
    socklen_t server_addr_len=sizeof(server_addr);

    sock=socket(AF_INET,SOCK_STREAM,0);
    connect(sock,(struct sockaddr*)&server_addr,server_addr_len);
    
    char buff[128];
    memset(buff,0,sizeof(buff));
    char *msg="I'm a clkient";

    while(1){
        write(sock,msg,strlen(msg));//write要用strlen

        read(sock,buff,sizeof(buff)-1);
        printf("服务器发送的消息: %s.\n",buff);
        sleep(1);
    }
    
    close(sock);



    return 0;
}
