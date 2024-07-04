#include <iostream>
using namespace std;


struct vec
{
    int *arr;
    int cap;
    int size;
};


void init(vec *p, int size);
void pushBack(vec *p , int value );
void pushBackAt(vec *p , int value , int index);
void deleteAt(vec *p , int index);
void print(vec *p);


int main(void)
{
    vec v;
    init(&v , 10);
    pushBack(&v ,0);
    pushBack(&v ,1);
    pushBack(&v ,2);
    pushBack(&v ,3);
    pushBack(&v ,4);
    pushBack(&v ,5);
    print(&v);
    pushBackAt(&v,10,3);
    print(&v);
    pushBackAt(&v,15,2);
    print(&v);
    pushBack(&v ,20);
    print(&v);
    deleteAt(&v,3);
    print(&v);
    deleteAt(&v,5);
    print(&v);
    pushBack(&v ,3);
    pushBack(&v ,4);
    pushBack(&v ,5);
    pushBack(&v ,5);
    print(&v);
}

void init(vec *p, int size) {
    p->arr = (int *)malloc(sizeof(int) * size);
    p->size = 0;
    p->cap = size; 
}


void pushBack(vec *p , int value )
{
    if(p->size == p->cap)
    {
        int *newArr = (int *)calloc((p->cap * 2), sizeof(int));
        for(int i=0;i<p->cap;i++)
        {
            newArr[i] = p->arr[i];
        }

        p->arr = newArr;
        p->arr[p->size++] = value;
        p->cap = (p->cap*2);
    }
    else
    {
        p->arr[p->size++] = value;
    }
}

void pushBackAt(vec *p , int value , int index) 
{
    if (p->size == p->cap)
    {
        int *newArr = (int *)calloc((p->size * 2), sizeof(int));
        for (int i = 0; i < p->cap; i++) 
        {
            newArr[i] = p->arr[i];
        }
        free(p->arr); 
        p->arr = newArr; 
        for (int i = p->size; i >= index; i--) 
        {
            p->arr[i + 1] = p->arr[i];
        }
        p->arr[index] = value; 
        p->cap = p->cap * 2; 
        p->size++; 
    } else 
    {
        for (int i = p->size; i >= index; i--) 
        {
            p->arr[i + 1] = p->arr[i];
        }
        p->arr[index] = value; 
        p->size++; 
    }
}


void deleteAt(vec *p , int index)
{
    if (index < 0 || index >= p->size) {
        cout << "Index out of bounds.\n";
        return;
    }
    
    for (int i = index; i < p->size - 1; i++) {
        p->arr[i] = p->arr[i + 1];
    }
    p->size--;
}


void print(vec *p) {
    cout << "Vector: ";
    for (int i = 0; i < p->size; i++) {
        cout << p->arr[i] << " ";
    }
    cout << endl;
    cout << " cap = " << p->cap<< " " << " size = " << p->size<< endl;
}
