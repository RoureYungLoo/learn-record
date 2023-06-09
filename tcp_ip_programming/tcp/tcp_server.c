#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<arpa/inet.h>
#include<sys/socket.h>

void error_handling(char* message);
int main(int argc, char const *argv[])
{

    int serv_sock;
    int clnt_sock;

    serv_sock =socket(AF_INET,SOCK_STREAM,IPPROTO_TCP);

    struct sockaddr_in serv_addr;
    memset(&serv_addr,0,sizeof(serv_addr));

    serv_addr.sin_family=AF_INET;
    serv_addr.sin_addr.s_addr=inet_addr("127.0.0.1"); //注意inet_addr
    serv_addr.sin_port=htons(3559); //htons

    bind(serv_sock,(struct sockaddr*)&serv_addr,sizeof(serv_addr));
    listen(serv_sock,5);

    struct sockaddr_in clnt_addr;
    memset(&clnt_addr,0,sizeof(clnt_addr));
    socklen_t clnt_addr_len=sizeof(clnt_addr);
    
    clnt_sock= accept(serv_sock,(struct sockaddr*)&clnt_addr,&clnt_addr_len);
    
    char buffer[128];
    char *msg="I'm a server";
    memset(buffer,0,sizeof(buffer));
    
    while (1) {
        read(clnt_sock,buffer,sizeof(buffer)-1);
        printf("客户端发送的消息：%s.\n",buffer);

        write(clnt_sock,msg,strlen(msg));//write要用strlen
        sleep(1);
    }
    


    close(clnt_sock);
    close(serv_sock);
    /* code */
    return 0;
}
