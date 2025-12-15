/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.nantes.infosi.jeudames;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agach
 */
public class Board {
    Piece[][] board = new Piece[10][10];


    public boolean inBounds(int x,int y){return x>=0&&x<10&&y>=0&&y<10;}


    public void init(){
        for(int i=0;i<10;i++) for(int j=0;j<10;j++) board[i][j]=null;
        for(int i=0;i<4;i++) for(int j=0;j<10;j++) if((i+j)%2==1) board[i][j]=new Pawn('n');
        for(int i=6;i<10;i++) for(int j=0;j<10;j++) if((i+j)%2==1) board[i][j]=new Pawn('b');
    }


    public List<Move> prisesJoueur(char c){
        List<Move> m = new ArrayList<>();
        for(int x=0;x<10;x++) for(int y=0;y<10;y++){
            if(board[x][y]!=null && board[x][y].color==c){
                m.addAll(board[x][y].prisesPossibles(x,y,this));
            }
        }
        return m;
    }


    void apply(Move m){
        Piece p = board[m.sx][m.sy];
        board[m.sx][m.sy]=null;
        if(m.prise) board[m.mx][m.my]=null;
        board[m.dx][m.dy]=p;
    }


    void promotion(){
        for(int y=0;y<10;y++){
            if(board[0][y] instanceof Pawn && board[0][y].color=='b') board[0][y]=new Dame('b');
            if(board[9][y] instanceof Pawn && board[9][y].color=='n') board[9][y]=new Dame('n');
        }
}


    void show(){
        System.out.println(" 0 1 2 3 4 5 6 7 8 9");
        for(int i=0;i<10;i++){
            System.out.print(i+" ");
            for(int j=0;j<10;j++){
                if(board[i][j]==null){ System.out.print(". ");}
                else{ System.out.print((board[i][j].estDame()?Character.toUpperCase(board[i][j].color):board[i][j].color)+" ");}
            }
        System.out.println();
        }
    }
}