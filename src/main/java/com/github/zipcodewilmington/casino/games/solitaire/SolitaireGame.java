package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import com.github.zipcodewilmington.utils.Node;

import java.util.List;
public class SolitaireGame implements GameInterface {
    private final String PROMPT = "Available Commands: (D)RAW,(R)ESET,(E)XIT,and \"x:y\" where x can be ta,b fa or TALON and y" +
            " can be fa or ta\n\t-x\n\t\t-ta,b = t is short for Tableu (the 7 stacks of cards at the bottom), a is the index of the Tableu(0-6 inclusive), and b is the number of" +
            " cards in the sequence you want to omit(0inclusive - (length of sequence)non-inclusive)\n\t\t" +
            "-fa = f is short for Foundation (the 4 initially empty stacks of cards), a is the index of the foundation (0-3 inclusive)\n\t\t" +
            "-TALON is the name given to the cards most immediately drawn from the draw pile\n" +
            "The colon represents a directional operator specifying where you want to put your selection (x goes to y)\n" +
            "\t-y\n\t\t-ta = tableu and index(you may place your selection only on the the top of a destination tableu stack)\n\t\t" +
            "-fa = foundation and index";
    private Stock stock;
    private Talon talon;
    private Tableu tableu;
    private Foundations foundations;
    private final IOConsole promptConsole = new IOConsole(AnsiColor.YELLOW);
    private final IOConsole stockConsole = new IOConsole(AnsiColor.BLUE);
    private final IOConsole talonConsole = new IOConsole(AnsiColor.PURPLE);
    private final IOConsole tableuConsole = new IOConsole(AnsiColor.GREEN);
    private final IOConsole errorConsole = new IOConsole(AnsiColor.WHITE);
    private final IOConsole redCardConsole = new IOConsole(AnsiColor.RED);
    private final IOConsole blackCardConsole = new IOConsole(AnsiColor.BLACK);

    //add multiplayer functionality
    private PlayerInterface player;
    public SolitaireGame(){
    }

    @Override
    public void add(PlayerInterface player) {
        this.player = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }

    @Override
    public void run() {
        if(player != null) {
            this.launchSequence();
            boolean keepGoing = true;
            //double check second condition
            while(((!this.foundations.areAllFoundationsFull()) && (!tableu.isTableuClear() || !talon.isEmpty() || !stock.isEmpty())) && keepGoing) {
                printGame();
                //ex command c1,2: c2
                List<String> input = player.play();
                if(input.get(0).equals("EXIT") || input.get(0).equals("E")){
                    keepGoing = false;
                }
                else if(!takeInput(input)){
                    errorConsole.println("INVALID COMMAND");
                }
            }
            if(!keepGoing){
                promptConsole.println("EXITING...");
            }
            else{
                promptConsole.println("NICCCCCEEE JOBBBBBB!!!");
            }
        }
        else{
                errorConsole.println("Players is empty");
        }
    }
    public void printGame() {
        promptConsole.println(PROMPT);
        stockConsole.println(stock.toString());
        this.talon.display();
        this.foundations.display();
        this.tableu.display();

    }
    //private when it comes to present
    public void launchSequence(){
        Deck deck = new Deck();
        deck.shuffle();
        this.tableu = new Tableu(deck);
        this.foundations = new Foundations();
        this.talon = new Talon();
        this.stock = new Stock(deck);
    }
    //make public after done
    //for point to point if its true then actually remove
    public boolean takeInput(List<String> input){
        //DRAW
        if(input.get(0).equals("DRAW") || input.get(0).equals("D")){
            if(!stock.isEmpty()){
                switch(stock.getSize()){
                    case 2:
                        talon.accept(stock.draw());
                        talon.accept(stock.draw());
                        return true;
                    case 1:
                        talon.accept(stock.draw());
                        return true;
                    case 0:
                        errorConsole.println("RESET STOCK");
                        return false;
                    default:
                        talon.accept(stock.draw());
                        talon.accept(stock.draw());
                        talon.accept(stock.draw());
                        return true;
                }
            }
            errorConsole.println("RESET STOCK");
            return false;
        }
        //RESET
        if(input.get(0).equals("RESET") || input.get(0).equals("R")){
            if(this.stock.isEmpty()){
                return this.stock.acceptTalon(talon.toStock());
            }
            return false;
        }
        //talon to foundation
        if(input.get(0).equals("TALON")) {
            if(input.get(1).equals("F")){
                if(foundations.addToFoundation(talon.preDonate(),Integer.parseInt(input.get(2)))) {
                    talon.donate();
                    return true;
                }
                return false;
            }
            //talon to tableu
            if(input.get(1).equals("T")){
                if(tableu.putCardsInTableu(Integer.parseInt(input.get(2)),new Node<>(talon.preDonate(),null))){
                    talon.donate();
                    return true;
                }
                return false;
            }
            errorConsole.println("Invalid command");
            return false;
        }
        //tableu to tableu
        if(input.get(0).equals("T")){
            int donorIndex;
            int receiverIndex;
            if(input.size() == 4){
                donorIndex = Integer.parseInt(input.get(1));
                receiverIndex = Integer.parseInt(input.get(3));
                //simplify by putting input.get into separate vars
                //if true then push
                if(input.get(2).equals("T")) {
                    //tableu to tableu; single card off the top |
                    if(tableu.putCardsInTableu(receiverIndex, tableu.peekCardsFromTableu(donorIndex, new Node<>(tableu.peekTopCard(donorIndex), null)))){
                        tableu.removeCardsFromTableu(donorIndex,new Node<>(tableu.peekTopCard(donorIndex), null));
                        return true;
                    }
                    errorConsole.println("tab to tab (1) error");
                    return false;
                }
                //tableu to foundation |
                else if(input.get(2).equals("F")){
                    if(foundations.addToFoundation(tableu.peekCardsFromTableu(donorIndex, new Node<>(tableu.peekTopCard(donorIndex), null)).getValue(),receiverIndex)){
                        tableu.removeCardsFromTableu(donorIndex,new Node<>(tableu.peekTopCard(donorIndex), null));//this line sus
                        return true;
                    }
                    errorConsole.println("tab to fou error");
                    return false;
                }
                //tableu to tableu sequence
            }
            else if(input.size()==5){//0 == t //1 == index //2 == nodestoomit //3 ==t; //4 == index
                int nodesToOmit = Integer.parseInt(input.get(2));
                donorIndex = Integer.parseInt(input.get(1));
                receiverIndex = Integer.parseInt(input.get(4));
                if(tableu.putCardsInTableu(receiverIndex, tableu.peekCardsFromTableu(donorIndex,nodesToOmit))){
                    tableu.removeCardsFromTableu(donorIndex,tableu.peekCardsFromTableu(donorIndex,nodesToOmit));
                    return true;
                }
                errorConsole.println("multi tab to tab error");
                return false;
            }
            errorConsole.println("general tab error");
            return false;
        }
        //foundation to foundation
        //0 = f; 1 = donor index; 2 = receiver; 3 = receiverIndex
        if(input.get(0).equals("F")){
            if(input.size() == 4) {
                int donorIndex = Integer.parseInt(input.get(1));
                int receiverIndex = Integer.parseInt(input.get(3));
                if(input.get(2).equals("F")){
                    if(foundations.addToFoundation(foundations.peekFromFoundation(donorIndex),receiverIndex)){
                        foundations.takeFromFoundation(donorIndex);
                        return true;
                    }
                    return false;
                }
                //foundation to tableu
                if(input.get(2).equals("T")){
                    if(tableu.putCardsInTableu(receiverIndex,new Node<>(foundations.peekFromFoundation(donorIndex),null))){
                        foundations.takeFromFoundation(donorIndex);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
