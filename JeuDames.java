/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fr.centrale.nantes.infosi.jeudames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author agach
 */
public class JeuDames {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        b.init();
        char joueur='b';


        while(true){    
            b.show();
            System.out.println("Tour du joueur : "+joueur);
            List<Move> prises = b.prisesJoueur(joueur);
            boolean obligation = !prises.isEmpty();
            if(obligation){ 
                System.out.println("Prise obligatoire !");
            }
            System.out.print("Départ (x y): ");
            int sx=sc.nextInt(), sy=sc.nextInt();
            System.out.print("Arrivée (x y): ");
            int dx=sc.nextInt(), dy=sc.nextInt();
            Piece p = b.board[sx][sy];
            if(p==null || p.color!=joueur){ System.out.println("Case invalide."); continue; }
            List<Move> valides = new ArrayList<>();
            if(obligation){ 
                valides = p.prisesPossibles(sx,sy,b);
            }
            else {
                valides.addAll(p.mouvementsPossibles(sx,sy,b));
                valides.addAll(p.prisesPossibles(sx,sy,b));
            }
            Move choisi=null;
            for(Move m:valides) {
                if(m.dx==dx&&m.dy==dy) {
                    choisi=m;
                }
            }
            if(choisi==null){ 
                System.out.println("Mouvement interdit."); continue; 
            }


            b.apply(choisi);
            b.promotion();


// prises multiples
            while(choisi.prise){
                List<Move> suite = b.board[dx][dy].prisesPossibles(dx,dy,b);
                if(suite.isEmpty()) break;
                b.show();
                System.out.println("Prise multiple : continue !");
                System.out.print("Nouvelle arrivée (x y): ");
                int nx=sc.nextInt(), ny=sc.nextInt();
                Move suivant=null;
                for(Move m:suite) {
                    if(m.dx==nx&&m.dy==ny) suivant=m;
                }
                if(suivant==null){ 
                    break; 
                }
                b.apply(suivant);
                b.promotion();
                dx=nx; dy=ny;
                choisi=suivant;
               }


            joueur = (joueur=='b')?'n':'b';
        }   
    }
}
