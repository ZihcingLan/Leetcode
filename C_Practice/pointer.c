int a; // 一個整型數
int *a; // 一個指向整數的指標
int **a; // 一個指向指標的指標，它指向的指標是指向一個整型數
int a[10]; // 一個有10個整數型的陣列
int *a[10]; // 一個有10個指標的陣列，該指標是指向一個整數型的
int (*a)[10]; // 一個指向有10個整數型陣列的指標
int (*a)(int); // 一個指向函數的指標，該函數有一個整數型參數並返回一個整數
int (*a[10])(int); // 一個有10個指標的陣列，該指標指向一個函數，該函數有一個整數型參數並返回一個整數
//秘訣是由後往前念

=============================
Compare 印出1 

int B = 2;
void func(int *p){p = &B;}
int main(){
     int A = 1, C = 3;
     int *ptrA = &A; //ptrA是去"複製"A的記憶體位置
     func(ptrA); //call by value，func中p是複製品，p=2不會修改到ptrA
     printf("%d\n", *ptrA); //用*印出ptrA的值=1
     return 0;
}

Compare 印出2

int B = 2;
void func(int **p){ *p = &B; } //QQQQ:可以*p = &B，那可以=*B嗎? A:No!因為B1不是指標，如果要換A的值->**p = B
int main(){
     int A = 1, C = 3;
     int *ptrA = &A; //同上，ptrA是去"複製"A的記憶體位置
     func(&ptrA); //call by reference，把ptrA的記憶體位置傳給p，*p代表又再去p裡面取地址，等於將存放A地址的地方變成B地址；
     printf("%d\n", *ptrA);
     return 0;
}

=============================
Explain this declairation.
void **(*d) (int &, char **(*)(char *, char **));
--------------------------------------------------------------------
+ d is a pointer to a function that takes two parameters:
    + a reference to an int and
    + a pointer to a function that takes two parameters:
        + a pointer to a char and
        + a pointer to a pointer to a char
    + and returns a pointer to a pointer to a char
+ and returns a pointer to a pointer to void

先看d是個指標，指向一個函式，這個函式有兩個參數，最後回傳一個指標的指標（void代表還不知道回傳的指標指向的型別）
接下來看參數，第一個參數int& 是c++才有（C是int *，第二個參數是一個指標指向另外一個函式，最後回傳一個指標的指標指向char。

=============================

[C] 透過函式記憶體配置 — malloc()malloc in another function
http://lee.logdown.com/posts/98518/c-through-the-function-malloc-memory-configuration
#include <stdio.h>
#include <stdlib.h>
void getMemory(char** s)
{
    *s = (char*)malloc(sizeof(char));
    printf("s = %p\n", s);
    printf("*s = %p\n", *s);
}
int main()
{
    char* ch = NULL;
    getMemory(&ch);
    printf("&ch = %p\n", &ch);
    printf("ch = %p\n", ch);
    return 0;
}
```````````````````````````````````````
s = 0x7fff5d2ebc00
*s = 0x7f943bc000e0
&ch = 0x7fff5d2ebc00
ch = 0x7f943bc000e0

=============================



=============================
