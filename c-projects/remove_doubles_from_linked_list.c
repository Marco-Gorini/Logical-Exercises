//
//  main.c
//  RemoveDoublesFromLinkedList
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
void removeDoublesFromLinkedList(HeadList* headList);

//MAIN

int main(int argc, const char * argv[]) {
    
    HeadList listOfNumbers;
    
    initializateList(&listOfNumbers);
    printLinkedList(listOfNumbers);
    removeDoublesFromLinkedList(&listOfNumbers);
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

//Remove doubles from the linked list

void removeDoublesFromLinkedList(HeadList* headList) {
    
    for(HeadList pointer1 = *headList; pointer1; pointer1 = pointer1 -> pointerToNextNode) {
        HeadList prec = NULL,curr = pointer1;
        while(curr){
            if(prec && curr -> numberInNode == pointer1 -> numberInNode) {
                HeadList nodeToEliminate = curr;
                prec -> pointerToNextNode = curr -> pointerToNextNode;
                curr = curr -> pointerToNextNode;
                free(nodeToEliminate);
                continue;
            }
            prec = curr;
            curr = curr -> pointerToNextNode;
        }
    }
    
}
