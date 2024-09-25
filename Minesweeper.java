import java.util.*; // imports all java utilities
public class Minesweeper{
    
    /*
    creates a 10x10 minefield
    uses 2d arrays, revealed contains player's progress, concealed contains the mines
    bombs have a value of -1
    blank squares have a value of -2
    */
    private int[][] minefieldRevealed = new int[10][10];
    private int[][] minefieldConcealed = new int[10][10];
    
    // displays the concealed matrix after the user has won/lost
    public void displayConcealed(){
        System.out.print("\t ");
        for(int x=0; x<10; x++){
            System.out.print(" " + x + "  ");
        }
        System.out.print("\n");
        for(int x=0; x<10; x++){
            System.out.print(x + "\t| ");
            for(int y=0; y<10; y++){
                if(minefieldConcealed[x][y]==0){
                    System.out.print(" ");
                }
                else if (minefieldConcealed[x][y]==-1){
                    System.out.print("X");
                } else {
                    System.out.print(minefieldConcealed[x][y]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }
    
    // method for checking if user has won
    public boolean checkWin(){
        for(int x=0; x<10; x++){
            for(int y=0; y<10; y++){
                if (minefieldRevealed[x][y]==0){
                    if (minefieldConcealed[x][y]!=100){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    // method for changing the revealed matrix
    public void fixRevealed(int x, int y){
        minefieldRevealed[x][y] = -2;
        if (x != 0){
            minefieldRevealed[x-1][y] = minefieldConcealed[x-1][y];
            if(minefieldRevealed[x-1][y]==0){
                minefieldRevealed[x-1][y] = -2;
            }
            if(y !=0 ) {
                minefieldRevealed[x-1][y-1] = minefieldConcealed[x-1][y-1];
                if(minefieldRevealed[x-1][y-1]==0){
                    minefieldRevealed[x-1][y-1]=-2;
                }
            }
        }
        if  (x != 9){
            minefieldRevealed[x+1][y] = minefieldConcealed[x+1][y];
            if(minefieldRevealed[x+1][y]==0){
                minefieldRevealed[x+1][y] = -2;
            }
            if(y != 9){
                minefieldRevealed[x+1][y+1] = minefieldConcealed[x+1][y+1];
                if(minefieldRevealed[x+1][y+1]==0){
                    minefieldRevealed[x+1][y+1]=-2;
                }
            }
        }
        if (y != 0){
            minefieldRevealed[x][y-1] = minefieldConcealed[x][y-1];
            if(minefieldRevealed[x][y-1]==0){
                minefieldRevealed[x][y-1] = -2;
            }
            if(x != 9){
                minefieldRevealed[x+1][y-1] = minefieldConcealed[x+1][y-1];
                if(minefieldRevealed[x+1][y-1]==0){
                    minefieldRevealed[x+1][y-1] = -2;
                }
            }
        }
        if (y != 9){
            minefieldRevealed[x][y+1] = minefieldConcealed[x][y+1];
            if(minefieldRevealed[x][y+1] == 0){
                minefieldRevealed[x][y+1] = -2;
            }
            if (y != 0){
                minefieldRevealed[x-1][y+1] = minefieldConcealed[x-1][y+1];
                if(minefieldRevealed[x-1][y+1]==0){
                    minefieldRevealed[x-1][y+1] = -2;
                }
            }
        }
    }
    
    // method for changing the hidden matrix
    public void fixNeighbors(int x, int y){
        Random random = new Random();
        int rdm = random.nextInt()%4;
        
        minefieldRevealed[x][y] = minefieldConcealed[x][y];
        
        if(rdm == 0){
            if(x!=0){
                if(minefieldConcealed[x-1][y] != -1){
                    minefieldRevealed[x-1][y] = minefieldConcealed[x-1][y];
                    if (minefieldRevealed[x-1][y] == 0){
                        minefieldRevealed[x-1][y] = -2;
                    }
                }
            }
            if(y!=0){
                if(minefieldConcealed[x][y-1] != -1){
                    minefieldRevealed[x][y-1] = minefieldConcealed[x][y-1];
                    if (minefieldRevealed[x][y-1] == 0){
                        minefieldRevealed[x][y-1] = -2;
                    }
                }
            }
            if(x!=0 && y!=0){
                if(minefieldConcealed[x-1][y-1] != -1){
                    minefieldRevealed[x-1][y-1] = minefieldConcealed[x-1][y-1];
                    if (minefieldRevealed[x-1][y-1] == 0){
                        minefieldRevealed[x-1][y-1] = -2;
                    }
                }
            }
        } else if (rdm == 1){
            if(x!=0){
                if(minefieldConcealed[x-1][y] != -1){
                    minefieldRevealed[x-1][y] = minefieldConcealed[x-1][y];
                    if (minefieldRevealed[x-1][y] == 0){
                        minefieldRevealed[x-1][y] = -2;
                    }
                }
            }
            if(y!=9){
                if(minefieldConcealed[x][y+1] != -1){
                    minefieldRevealed[x][y+1] = minefieldConcealed[x][y+1];
                    if (minefieldRevealed[x][y+1] == 0){
                        minefieldRevealed[x][y+1] = -2;
                    }
                }
            }
            if(x!=0 && y!=9){
                if(minefieldConcealed[x-1][y+1] != -1){
                    minefieldRevealed[x-1][y+1] = minefieldConcealed[x-1][y+1];
                    if (minefieldRevealed[x-1][y+1] == 0){
                        minefieldRevealed[x-1][y+1] = -2;
                    }
                }
            }
        } else if (rdm == 2){
            if(x!=9){
                if(minefieldConcealed[x+1][y] != -1){
                    minefieldRevealed[x+1][y] = minefieldConcealed[x+1][y];
                    if (minefieldRevealed[x+1][y] == 0){
                        minefieldRevealed[x+1][y] = -2;
                    }
                }
            }
            if(y!=9){
                if(minefieldConcealed[x][y+1] != -1){
                    minefieldRevealed[x][y+1] = minefieldConcealed[x][y+1];
                    if (minefieldRevealed[x][y+1] == 0){
                        minefieldRevealed[x][y+1] = -2;
                    }
                }
            }
            if(x!=9 && y!=9){
                if(minefieldConcealed[x+1][y+1] != -1){
                    minefieldRevealed[x+1][y+1] = minefieldConcealed[x+1][y+1];
                    if (minefieldRevealed[x+1][y+1] == 0){
                        minefieldRevealed[x+1][y+1] = -2;
                    }
                }
            }
        } else {
            if(x!=9){
                if(minefieldConcealed[x+1][y] != -1){
                    minefieldRevealed[x+1][y] = minefieldConcealed[x+1][y];
                    if (minefieldRevealed[x+1][y] == 0){
                        minefieldRevealed[x+1][y] = -2;
                    }
                }
            }
            if(y!=0){
                if(minefieldConcealed[x][y-1] != -1){
                    minefieldRevealed[x][y-1] = minefieldConcealed[x][y-1];
                    if (minefieldRevealed[x][y-1] == 0){
                        minefieldRevealed[x][y-1] = -2;
                    }
                }
            }
            if(x!=9 && y!=0){
                if(minefieldConcealed[x+1][y-1] != -1){
                    minefieldRevealed[x+1][y-1] = minefieldConcealed[x+1][y-1];
                    if (minefieldRevealed[x+1][y-1] == 0){
                        minefieldRevealed[x+1][y-1] = -2;
                    }
                }
            }
        }
    }
    
    // method for player input
    public boolean userMove(){
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter Row Number: ");
        int x = scan.nextInt();
        System.out.print("Enter Column Number: ");
        int y = scan.nextInt();
        
        if(x < 0 || x > 9 || y < 0 || y > 9 || minefieldRevealed[x][y] != 0){
            System.out.print("Invalid Input.\n");
            return true;
        }
        
        if(minefieldConcealed[x][y] == -1){
            displayConcealed();
            System.out.print("BOOM! You Lose.");
            return false;
        } else if (minefieldConcealed[x][y] == 0){
            fixRevealed(x,y);
        } else {
            fixNeighbors(x,y);
        }
        return true;
    }
    // method to show player their progress
    public void displayRevealed(){
        System.out.print("\t ");
        for(int x=0; x<10; x++){
            System.out.print(" " + x + "  ");
        }
        System.out.print("\n");
        for(int x=0; x<10; x++){
            System.out.print(x + "\t| ");
            for(int y=0; y<10; y++){
                if(minefieldRevealed[x][y]==0){
                    System.out.print("?");
                } else if(minefieldRevealed[x][y]==-2){
                    System.out.print(" ");
                } else {
                    System.out.print(minefieldRevealed[x][y]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }
                
    // method for creating concealed matrix with the numbers of neighboringMines in each index
    public void createConcealed(){
        for(int x=0; x<10; x++){
            for(int y=0; y<10; y++){
                int neighboringMines = 0;
                
                //will not have number of neighboringMines if index is a mine
                if(minefieldConcealed[x][y] != -1){
                    
                    //checks if index is at left edge
                    if(x != 0){
                        
                        //if not, check left index for mine
                        if(minefieldConcealed[x-1][y] == -1){
                            neighboringMines++;
                        }
                        //checks if index is at top edge, if not check top left
                        if( y != 0){
                            if(minefieldConcealed[x-1][y-1] == -1){
                                neighboringMines++;
                            }
                        }
                    }
                    
                    //repeat process for each corner
                    if(x != 9){
                        if(minefieldConcealed[x+1][y] == -1){
                            neighboringMines++;
                        }
                        if( y != 9){
                            if(minefieldConcealed[x+1][y+1] == -1){
                                neighboringMines++;
                            }
                        }
                    }
                    if(y != 0){
                        if(minefieldConcealed[x][y-1] == -1){
                            neighboringMines++;
                        }
                        if( x != 9){
                            if(minefieldConcealed[x+1][y-1] == -1){
                                neighboringMines++;
                            }
                        }
                    }
                    if(y != 9){
                        if(minefieldConcealed[x][y+1] == -1){
                            neighboringMines++;
                        }
                        if( x != 0){
                            if(minefieldConcealed[x-1][y+1] == -1){
                                neighboringMines++;
                            }
                        }
                    }
                    
                    //set the index of number of neighboringMines
                    minefieldConcealed[x][y] = neighboringMines;
                }
            }
        }
    }
    
    // method to create the minefield
    public void createMinefield(){
        int mines = 0;
        while(mines != 21){
            
            //generates coordinates for the 21 mines
            Random random = new Random();
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            
            //shows the coordinates for the mines (delete later)
            System.out.println("x: " + x + " y: " + y);
            
            //mines will have a value -1 at given coordinates
            minefieldConcealed[x][y] = -1;
            mines++;
        }
        createConcealed();
    }
    
    // method to begin the game
    public void begin(){
        System.out.println("Welcome to Minesweeper.");
        
        //will set up the minefield using createMinefield class
        createMinefield();
        
        boolean running = true;
        //keeps the game running until player wins/loses.
        while(running){
            
            //this will show the player their progress
            displayRevealed();
            
            /*
            allows the user to input their move
            if the user moves onto a mine, they lose
            */
            running = userMove();
            
            //checks if the user has cleared all empty spots without hitting mines
            if (checkWin()){
                
                //shows the location of all the mines
                displayConcealed();
                
                //final statement, program end
                System.out.println("You Win!");
                break;
            }
        }
    }
    
    // main method
    public static void main(String args[]){
        
        //creates Minesweeper class
        Minesweeper MS = new Minesweeper();
        //initiates the game
        MS.begin();
    }
}