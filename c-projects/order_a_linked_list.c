//
//  main.c
//  OrderLinkedList
//
//  Created by Marco Gorini on 10/11/2022.
//  Copyright © 2022 Marco Gorini. All rights reserved.
//

#include <stdio.h>
#include<stdlib.h>

//STRUCT DEFINING

typedef struct Node {
    int numberInNode;
    struct Node *pointerToNextNode;
} Node_t;
typedef Node_t *HeadList;

//FUNCTIONS

void initializateList(HeadList* headList);
void addNode(HeadList* headList, int numberToInsert);
void printLinkedList(HeadList headList);
void orderLinkedList(HeadList* headList);

//MAIN

int main(int argc, const char * argv[]) {
    
    HeadList listOfNumbers;
    
    initializateList(&listOfNumbers);
    printLinkedList(listOfNumbers);
    orderLinkedList(&listOfNumbers);
    printLinkedList(listOfNumbers);
}


//Filling the list until the number is 0

void initializateList(HeadList* headList) {
    
    int inputNumber;
    
    while(scanf("%d", &inputNumber) && inputNumber != 0){
        addNode(headList,inputNumber);
    }
        
}

//Add a node to the linked list

void addNode(HeadList* headList, int numberToInsert) {
    
    HeadList newNode = malloc(sizeof(Node_t));
    
    if(newNode) {
        newNode -> numberInNode = numberToInsert;
        newNode -> pointerToNextNode = *headList;
        *headList = newNode;
    }
    
}

//Print the linked list

void printLinkedList(HeadList headList) {
    
    for(HeadList pointer = headList; pointer ; pointer = pointer -> pointerToNextNode) {
        printf("%d ", pointer -> numberInNode);
    }
    printf("\n");
    
}

//Order a list

void orderLinkedList(HeadList* headList) {
    
    for(HeadList pointer1 = *headList; pointer1 ; pointer1 = pointer1 -> pointerToNextNode) {
        int min = pointer1 -> numberInNode;
        for(HeadList pointer2 = pointer1; pointer2; pointer2 = pointer2->pointerToNextNode) {
            if(pointer2 -> numberInNode < min){
                min = pointer2 -> numberInNode;
            }
        }
        HeadList pointerToSubstitute = pointer1;
        for(; pointerToSubstitute->numberInNode != min; pointerToSubstitute = pointerToSubstitute -> pointerToNextNode);
        pointerToSubstitute -> numberInNode = pointer1 -> numberInNode;
        pointer1 -> numberInNode = min;
    }
}

