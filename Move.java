/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.nantes.infosi.jeudames;

/**
 *
 * @author agach
 */
public class Move{
    int sx,sy,dx,dy; boolean prise; int mx,my;
    Move(int sx,int sy,int dx,int dy,boolean p){ 
        this(sx,sy,dx,dy,p,-1,-1);
    }
    Move(int sx,int sy,int dx,int dy,boolean p,int mx,int my){
        this.sx=sx;this.sy=sy;this.dx=dx;this.dy=dy;this.prise=p;this.mx=mx;this.my=my;
    }
}
