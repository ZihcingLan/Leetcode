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
