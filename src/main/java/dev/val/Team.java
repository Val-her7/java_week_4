package dev.val;

public class Team {

    private String name;
    private Player player;

    public Team(Player player){
        System.out.println("Team Constructor");
        this.player = player;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void play() {
        System.out.println("The team is playing!");
        player.isInTeam();
    }
}