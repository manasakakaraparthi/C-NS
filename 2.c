#include<stdio.h>
#include<string.h>
int main()
{
    char str[]="Hello World";
    int i,length;
    char ch;
    length=strlen(str);
    printf("Original String is:%s\n\n",str);
    printf("Encrypted string with AND:\n");
    for(i=0;i<length;i++){
        ch=str[i]&127;
        printf("%c",ch);

    }
    printf("\n\n Encrypted string with XOR:\n");
    for(i=0;i<length;i++)
    {
        ch=str[i]^127;
        printf("%c",ch);
    }
    return 0;
}