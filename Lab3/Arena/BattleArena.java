package Arena;
import Droids.*;

import java.util.ArrayList;
import java.util.Random;

public class BattleArena {

    public static void printCommandList(){
        System.out.println("\tПерелік доступних команд");
        System.out.println("\t______________________________");
        System.out.println("\t1 - створити дроїда\n\t2 - показати список дроїдів\n\t3 - запустити бій 1 vs 1" +
                "\n\t4 - запустити командний бій\n\t5 - вийти з гри");
        System.out.println("\t------------------------------\n");
    }

    public void startBattle(Droid fighter1, Droid fighter2){
        Droid winner = soloFight(fighter1, fighter2);
        System.out.printf("Переможець '%s' з %.2f hp\n", winner.getName(), winner.getHealth());
    }

    public void startBattle(ArrayList<Droid> team1, ArrayList<Droid> team2){

        int winner = teamFight(team1, team2);
        System.out.println("\n\tПеремогла команда №" + winner + "\n");
        ArrayList<Droid> winnerTeam;
        if(winner == 1){
            winnerTeam = team1;
        }else{
            winnerTeam = team2;
        }
        for (int i = 0; i < winnerTeam.size(); i++) {
            System.out.println("\t| " + winnerTeam.get(i).toString());
        }
    }

    public static boolean bothAlive(Droid fighter1, Droid fighter2){
        if((fighter1.isAlive()) && (fighter2.isAlive())) return true;
        else return false;
    }

    public static boolean bothAlive(ArrayList<Droid> team1, ArrayList<Droid> team2){
        int tsize1 = getTeamSize(team1);
        int tsize2 = getTeamSize(team2);

        if((tsize1!=0) && (tsize2!=0)) return true;
        else return false;
    }

    public static int getTeamSize(ArrayList<Droid> team){
        int tsize = 0;
        for (int i = 0; i < team.size(); i++) {
            if(team.get(i).getHealth()>0){
                tsize++;
            }
        }
        return tsize;
    }

    public static Droid soloFight(Droid fighter1, Droid fighter2){
        while(bothAlive(fighter1, fighter2)){
            fighter1.attack(fighter2);
            if(!bothAlive(fighter1, fighter2)) break;
            fighter2.attack(fighter1);
        }
        if (fighter1.isAlive()) return fighter1;
        else return fighter2;
    }
    public static int teamFight(ArrayList<Droid> team1, ArrayList<Droid> team2){

        while(bothAlive(team1, team2)) {

            setFighters(team1, team2);
            if(!bothAlive(team1, team2)) break;
            setFighters(team2, team1);
        }

        double sumHealth = 0;
        for (int i = 0; i < team1.size(); i++) {
            sumHealth+=team1.get(i).getHealth();
        }
        if(sumHealth>0) return 1;
        else return 2;
    }

    public static void setFighters(ArrayList<Droid> attackers, ArrayList<Droid> defenders){
        for (Droid droid : attackers){
            if(droid.isAlive()){
                Droid randDroid = getRandomDroid(defenders);
                if(randDroid.isAlive()){
                    if(droid instanceof Healer) {
                        Droid randAttacker = getRandomDroid(attackers);
                        ((Healer) droid).healFriendly(randAttacker);
                    }
                    droid.attack(randDroid);
                }

            }
        }

    }

    public static Droid getRandomDroid(ArrayList<Droid> team){
        int b = team.size();
        Random rand = new Random();
        int randInd = rand.nextInt(b);
        return team.get(randInd);
    }
}
