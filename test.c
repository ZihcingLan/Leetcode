//C 語言練習題

1. Set and clear a particular bit of a value.
void set_bit(unsigned int *val, unsigned int n){
    *val |= (1U<<n);
}
or
unsigned int set_bit(unsigned int val, unsigned int n){
    val |= (1U<<n);
}

void clear_bit(unsigned int *val, unsigned int n){
    *val &= ~(1U<<n);
}

2. Define a max function.
#define MAX(a,b) ((a) >= (b) ? (a) : (b))

3. Implement the function char * strcpy(char * dest, const char * src).

char * strcpy(char * dest, const char * src){
    char *d = dest;
    while (src != NULL){
        dest = src;
        dest++;
        src++;
    }
    return d;
}

4. Build a function to add a node at the end of a linked list.
#include <stdio.h>
#include <stdlib.h>

typedef struct Node{
    int val;
    struct Node *next;
} Node;

void addNode(Node **head, int data){
    Node *newNode = (Node *)malloc(sizeof(Node));
    if (newNode == NULL){
        return;
    }
    newNode->val = data;
    newNode->next = NULL;
    if (*head == NULL){
        *head = newNode;
        return;
    }
    Node *cur = *head;
    while (cur->next != NULL){
        cur = cur->next;
    }
    cur->next = newNode;
}


5. Build a function to reverse a linked list.
typedef struct Node{
    int val;
    struct Node *next;
}Node;

Node * reverseList(Node* head){
    Node *pre = NULL;
    Node *cur = head;
    Node *nextNode = NULL;
    while (cur != NULL){
        nextNode = cur->next;
        cur->next = pre;
        pre = cur;
        cur = nextNode;
    }
    return pre; //void - *head = pre;
}


6. Build a function to return the available capacity of a ring buffer.
#define BUFFER_SIZE 128

// 1. 結構體定義：使用 char* 指針追蹤讀寫位置
typedef struct struct_RingBuf {
    char *wptr;             // 指向 data_buffer，表示新資料寫入的起始位址 (Write Pointer)
    char *rptr;             // 指向 data_buffer，表示可讀取資料的起始位址 (Read Pointer)
    char buffer[BUFFER_SIZE]; // 實際的資料緩衝區
} RingBuf;

int space(RingBuf *rb){
    if (rb->wptr == NULL || rb->rptr == NULL){
        return -1;
    }
    int w_idx = rb->wptr - rb->buffer;
    int r_idx = rb->rptr - rb->buffer;
    int used = (w_idx - r_idx + BUFFER_SIZE) % BUFFER_SIZE;
    int remain = BUFFER_SIZE - used;
    return remain;
}