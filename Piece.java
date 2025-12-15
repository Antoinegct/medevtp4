/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.nantes.infosi.jeudames;

import java.util.List;

/**
 *
 * @author agach
 */
public abstract class Piece {
    char color; // 'b' ou 'n'
    Piece(char c){ this.color = c; }
    abstract boolean estDame();
    abstract List<Move> mouvementsPossibles(int x, int y, Board board);
    abstract List<Move> prisesPossibles(int x, int y, Board board);
}
