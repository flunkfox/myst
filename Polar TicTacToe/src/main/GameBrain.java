/*Name:	Alex Moczarski
 *Date: 05/19/2020
 *Period: 08
 *Teacher: Mr. Klus
 *Description:
 */
package main;


public class GameBrain
{
    private int[][] board = new int[6][5];
    private String winner;
    
    
    
    /*public void setUpR()//sets up the board to test if the radial win check is working correctly
    {
        board[0][0]=2;
        board[1][0]=2;
        board[2][0]=2;
        board[3][0]=2;
        board[4][0]=0;
        board[5][0]=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=1;j<board[0].length;j++)
            {
                board[i][j]=0;
            }
        }
    }
    */
    /*public void setUpL()//sets up the board to test if the linear win check is working correctly
    {
        board[0][0]=1;
        board[0][1]=1;
        board[0][2]=1;
        board[0][3]=1;
        board[0][4]=0;
        for(int i=1; i<board.length;i++)
        {
            for(int j=0; j<board[0].length;j++)
            {
                board[i][j]=0;
            }
        }
    }
    */
    /*public void setUpD()// sets up the board to test if the diagonal win check is working properly
    {
        board[0][0]=1;
        for(int i=1; i<board[0].length;i++)
        {
            board[0][i]=0;
        }
        board[1][0]=0;
        board[1][1]=1;
        for(int j=2; j<board[1].length;j++)
        {
            board[1][j]=0;
        }
        board[2][0]=0;
        board[2][1]=0;
        board[2][2]=1;
        for(int k=3; k<board[2].length;k++)
        {
            board[2][k]=0;
        }
        board[3][0]=0;
        board[3][1]=0;
        board[3][2]=0;
        board[3][3]=1;
        for(int b=4; b<board[3].length; b++)
        {
            board[3][b]=0;
        }
        for(int v=4; v<board.length; v++)
        {
            for(int g=0; g<board[v].length;g++)
            {
                board[v][g]=0;
            }
        }
    }
    */
    
    public void setUp()
    {
        for(int i=0; i<board.length;i++)
        {
            for(int j=0; j<board[i].length;j++)
            {
                board[i][j]=0;
            }
        }
    }
    //method to see if the game has been won either of the three ways
    public boolean gameWin()
    {
        //this piece of gameWin checks to see if there is a current linear victory on the board, and records which player won
        for(int i=0; i<board.length;i++)
        {
            if(board[i][0]!=0&&board[i][0]==board[i][1]&&board[i][2]==board[i][1]&&board[i][2]==board[i][3])
            {
                if(board[i][0]==1)
                    winner = "Player 1";
                else    
                    winner = "Player 2";
                System.out.println(winner);
                return true;
            }
            else if(board[i][1]!=0&&board[i][1]==board[i][2]&&board[i][2]==board[i][3]&&board[i][3]==board[i][4])
            {
                if(board[i][1]==1)
                    winner = "Player 1";
                else    
                    winner = "Player 2";
                System.out.println(winner);
                return true;
            }
           
            
            
        }
        //This section of gameWin checks the board to see if there is a current radial victory, and it records who won
        for(int j=0; j<board[0].length;j++)
        {
            if(board[0][j]!=0&&board[0][j]==board[1][j]&&board[1][j]==board[2][j]&&board[2][j]==board[3][j])
            {
                if(board[0][j]==1)
                    winner = "Player 1";
                else    
                    winner = "Player 2";
                System.out.println(winner);
                return true;
            }
            else if(board[1][j]!=0&&board[1][j]==board[2][j]&&board[2][j]==board[3][j]&&board[3][j]==board[4][j])
            {
                if(board[1][j]==1)
                    winner = "Player 1";
                else    
                    winner = "Player 2";
                System.out.println(winner);
                return true;
            }
            else if(board[2][j]!=0&&board[2][j]==board[3][j]&&board[3][j]==board[4][j]&&board[4][j]==board[5][j])
            {
                if(board[2][j]==1)
                    winner = "Player 1";
                else    
                    winner = "Player 2";
                System.out.println(winner);
                return true;
            }
            
        }
        int a =0;
        //This section of gameWin will check to see if there is a current diagonal win on the board and records the winner
        while(a<3)//rows- if a>3 the diagonal pattern will not be continuous and will not count as a victory
        {
            for(int b=0; b<board[0].length; b++)//columns
            {
                if(board[a][b]==1)
                {
                    if(b==0)
                    {
                        if(board[a+1][4]==1&&board[a+2][3]==1&&board[a+3][2]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][b+1]==1&&board[a+2][b+2]==1&&board[a+3][b+3]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }
                    }
                    else if(b==1)
                    {
                        if(board[a+1][0]==1&&board[a+2][4]==1&&board[a+3][3]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][b+1]==1&&board[a+2][b+2]==1&&board[a+3][b+3]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }
                    }
                    else if(b==2)
                    {
                        if(board[a+1][1]==1&&board[a+2][0]==1&&board[a+3][4]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][b+1]==1&&board[a+2][b+2]==1&&board[a+3][0]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }
                    }
                    else if(b==3)
                    {
                        if(board[a+1][b-1]==1&&board[a+2][b-2]==1&&board[a+3][b-3]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][b+1]==1&&board[a+2][0]==1&&board[a+3][1]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }

                    }
                    else if(b==4)
                    {
                        if(board[a+1][b-1]==1&&board[a+2][b-2]==1&&board[a+3][b-3]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][0]==1&&board[a+2][1]==1&&board[a+3][2]==1)
                        {
                            winner = "Player 1";
                            System.out.println(winner);
                            return true;
                        }
                    }
                    
                }
                else if(board[a][b]==2)
                {
                    if(b==0)
                    {
                        if(board[a+1][4]==2&&board[a+2][3]==2&&board[a+3][2]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][b+1]==2&&board[a+2][b+2]==2&&board[a+3][b+3]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }
                    }
                    else if(b==1)
                    {
                        if(board[a+1][0]==2&&board[a+2][4]==2&&board[a+3][3]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][b+1]==2&&board[a+2][b+2]==2&&board[a+3][b+3]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }
                    }
                    else if(b==2)
                    {
                        if(board[a+1][1]==2&&board[a+2][0]==2&&board[a+3][4]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][b+1]==2&&board[a+2][b+2]==2&&board[a+3][0]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }
                    }
                    else if(b==2)
                    {
                        if(board[a+1][b-1]==2&&board[a+2][b-2]==2&&board[a+3][b-3]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][b+1]==2&&board[a+2][0]==2&&board[a+3][1]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }

                    }
                    else if(b==4)
                    {
                        if(board[a+1][b-1]==2&&board[a+2][b-2]==2&&board[a+3][b-3]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }
                        else if(board[a+1][0]==2&&board[a+2][1]==2&&board[a+3][2]==2)
                        {
                            winner = "Player 2";
                            System.out.println(winner);
                            return true;
                        }
                    }
                    
                }
            }
            a++;
        }
        return false;
        
    }
    public boolean isLegal(int x, int y)
    {
        if(board[x][y] ==0)
        {
            return true;
        }
        else
            return false;
    }
    public void compComp()
    {
        boolean test = true;
        while(test = true)
        {
            int row = (int)(Math.random()*6);
            int col = (int)(Math.random()*5);
            if(isLegal(row, col)==true)
            {
                test = false;
                //player 2 to board[row][col]
            }
           
                
        }
        
        
    }

}
