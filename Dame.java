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
public class Dame extends Piece {
    Dame(char c){ super(c); }
    boolean estDame(){ return true; }


    public List<Move> mouvementsPossibles(int x, int y, Board b){
        List<Move> moves = new ArrayList<>();
        int[] dx = {-1,-1,1,1};
        int[] dy = {-1,1,-1,1};
        for(int d=0; d<4; d++){
            int nx=x+dx[d], ny=y+dy[d];
            while(b.inBounds(nx,ny) && b.board[nx][ny]==null){
                moves.add(new Move(x,y,nx,ny,false));
                nx+=dx[d]; ny+=dy[d];
            }
        }
    return moves;
    }


List<Move> prisesPossibles(int x, int y, Board b){
List<Move> moves = new ArrayList<>();
int[] dx = {-1,-1,1,1};
int[] dy = {-1,1,-1,1};
for(int d=0; d<4; d++){
int nx=x+dx[d], ny=y+dy[d];
boolean ennemiTrouve=false; int mx=-1,my=-1;
while(b.inBounds(nx,ny)){
if(!ennemiTrouve){
if(b.board[nx][ny]!=null){
if(b.board[nx][ny].color==color) break;
ennemiTrouve=true;
mx=nx; my=ny;
}
} else {
if(b.board[nx][ny]==null){
moves.add(new Move(x,y,nx,ny,true,mx,my));
} else break;
}
nx+=dx[d]; ny+=dy[d];
}
}
return moves;
}
}