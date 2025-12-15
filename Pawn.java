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
public class Pawn extends Piece {
    Pawn(char c){ super(c); }
    boolean estDame(){ return false; }


    public List<Move> mouvementsPossibles(int x, int y, Board b){
        List<Move> moves = new ArrayList<>();
        int dir = (color=='b') ? -1 : 1;
        int[] dy = {-1,1};
        for(int d:dy){
            int nx = x+dir;
            int ny = y+d;
            if(b.inBounds(nx,ny) && b.board[nx][ny]==null){
                moves.add(new Move(x,y,nx,ny,false));
            }
        }
    return moves;
    }


    public List<Move> prisesPossibles(int x, int y, Board b){
        List<Move> moves = new ArrayList<>();
        int dir = (color=='b') ? -1 : 1;
        int[] dy = {-1,1};
        for(int d:dy){
            int mx = x+dir, my = y+d;
            int lx = x+2*dir, ly = y+2*d;
            if(b.inBounds(lx,ly) && b.inBounds(mx,my)
            && b.board[lx][ly]==null
            && b.board[mx][my]!=null
            && b.board[mx][my].color!=color){
                moves.add(new Move(x,y,lx,ly,true,mx,my));
            }
        }
    return moves;
    }
}