#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int checkCode(char* code) {
    printf("%s\n", code);
    for(int i = 0; i < 13; i++) {
        for(int j = i+1; j < 14; j++) {
            if(code[i] == code[j]) {
                return 0;
            }
        }
    }
    return 1;
}

int readFile(char *path) {
    FILE *fp;
    char ch;
    char code[14];

    int counter = 0;

    memset(code, 0, sizeof(code));

    fp = fopen(path, "r");

    if (NULL == fp) {
        fprintf(stderr, "file can't be opened \n");
        return 0;
    }

    int position = 0;

    for(int i = 0; i < 14; i++) {
        code[i] = fgetc(fp);
        counter++;
        printf("%s\n", code);
    }

    if(checkCode(code) == 1) return counter;


    
    do {
        ch = fgetc(fp);
        for(int i = 0; i < 13; i++) {
            code[i] = code[i+1];
        }
        code[13] = ch;
        counter++;
        if(checkCode(code) == 1) return counter;
    } while (ch != '\n');
    

    printf("rip lol");
    return 0;
    /*for(int i = 0; i < edges; i++) {
        position = 0;
        memset(line, 0, sizeof(line));
        do {
            ch = fgetc(fp);
            line[position] = ch;
            position++;
        } while (ch != '\n');
        int from = (int) strtol(line, &ptr, 10);
        int to = (int) strtol(ptr, &ptr, 10);
        addNeighbor(graf, from, to);
    }*/
}



int main() {
    int answer = readFile("input.txt");

    printf("\nAnswer: %d\n", answer);

    return 0;
}