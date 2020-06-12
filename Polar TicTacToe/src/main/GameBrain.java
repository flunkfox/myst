/*Name: Alex Moczarski
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
    private int turn=1;
    private int score1=0;
    private int score2 =0;
    private boolean singlePlayer;
    private int gamesLeft;
    //returns the value in the 2d array at a given space
    public int getBoardValue(int r, int c)
    {
        return board[r][c];
    }
    
    //sets the given space to either 1 or 2, depending on whos turn it is
    public boolean setSpace(int r, int c)
    {
        if(isLegal(r,c)==true)
        {
            board[r][c]= whosTurn();
            turn++;
            return true;
        }
        return false;
    }
    
   
    //post: this method sets each space in the array to 0 to easily compare values of each space later in the game
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
    
    //this method sets the mode to either single player or multiplayer
    public void setMode(String mode)
    {
        if(mode=="singleplayer")
        {
           singlePlayer=true; 
        }
        else
            singlePlayer=false;
    }
    
    public boolean radialRecurse(int player, int row, int col, int count)
    {
    	int nextrow;
    	if(row + 1 > 5)
    		nextrow = 0;
    	else
    		nextrow = row + 1;
    	
    	if(count == 4)
    		return true;
    	else if(board[nextrow][col] == player)
    	{
    		count++;
    		return radialRecurse(player, nextrow, col, count);
    	}
    	else
    		return false;
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
                {
                    winner = "Player 1";
                    score1++;
                }
                else
                {
                    winner = "Player 2";
                    score2++;
                }
                System.out.println(winner);
                gamesLeft--;
                return true;
            }
            else if(board[i][1]!=0&&board[i][1]==board[i][2]&&board[i][2]==board[i][3]&&board[i][3]==board[i][4])
            {
                if(board[i][1]==1)
                {
                    winner = "Player 1";
                    score1++;
                }
                    
                else    
                {
                    winner = "Player 2";
                    score2++;
                }
                System.out.println(winner);
                gamesLeft--;
                return true;
            }
           
            
            
        }
        //This section of gameWin checks the board to see if there is a current radial victory, and it records who won
        for(int i = 0; i < board[0].length; i++)
        {
        	for(int k = 0; k < board.length; k++)
            {
            	if(board[k][i] != 0 && radialRecurse(board[k][i],k,i,1))
            	{
            	    if(board[k][i]==1)
            	        score1++;
            	    else
            	        score2++;
            		//win scenario
            		winner = ("Player " + board[k][i]);
            		gamesLeft--;
            		return true;
            	}
            }
        }
        
        
        //This section of gameWin will check to see if there is a current diagonal win on the board and records the winner
        for(int i = 0; i < board[0].length ; i++)
        {
        	for(int k = 0; k < board.length; k++)
            {
            	if(board[k][i] != 0 && rightDiagonalRecurse(board[k][i],k,i,1))
            	{
            	    if(board[k][i]==1)
                        score1++;
                    else
                        score2++;
                    //win scenario
                    winner = ("Player " + board[k][i]);
                    gamesLeft--;
                    return true;
            	}
            	if(board[k][i] != 0 && leftDiagonalRecurse(board[k][i],k,i,1))
            	{
            	    if(board[k][i]==1)
                        score1++;
                    else
                        score2++;
                    //win scenario
                    winner = ("Player: " + board[k][i]);
                    gamesLeft--;
                    return true;
            	}
            }
        }
        return false;
        
    }
    
    public boolean leftDiagonalRecurse(int player, int row, int col, int count)
    {
    	int nextrow;			
    	//gets the next row
	    if(row - 1 < 0)
	   		nextrow = 5;
	   	else
	   		nextrow = row - 1;
    	
	    int nextcol = col + 1;
	    if(col==4 && count == 4)
	    {
                return true;
	    }
	    else if(nextcol < 5)
    	{
    		if(count == 4)
	    		return true;
	    	else if(board[nextrow][nextcol] == player)
	    	{
	    		count++;
	    		return leftDiagonalRecurse(player, nextrow, nextcol, count);
	    	}	
    	}
    	return false;
    }
    
    public boolean rightDiagonalRecurse(int player, int row, int col, int count)
    {
    	int nextrow;			
    	//gets the next row
	    if(row + 1 > 5)
	   		nextrow = 0;
	   	else
	   		nextrow = row + 1;
    	
	    int nextcol = col + 1;
	    if(col==4 && count == 4)
	    {
                return true;
	    }
	    else if(nextcol < 5)
    	{
    		if(count == 4)
	    		return true;
	    	else if(board[nextrow][nextcol] == player)
	    	{
	    		count++;
	    		return rightDiagonalRecurse(player, nextrow, nextcol, count);
	    	}	
    	}
    	return false;
    }
    
        
        
    //pre: int x and int y are variables representing the row and column in the array that the current player has selected to play at
    //post: returns true if the selected space is unoccupied, false if the space is occupied
    public boolean isLegal(int x, int y)
    {
        if(board[x][y] ==0)
        {
            return true;
        }
        else
            return false;
    }
    
    //very intelligent AI that uses math.random to select a space to play in, if its not occupied - used for 1 player games
    public String compComp()
    {
        int r = 0;
        int c =0;
        boolean test = true;
        while(test == true)
        {
            int row = (int)(Math.random()*6);
            int col = (int)(Math.random()*5);
            if(isLegal(row, col)==true)
            {
                test = false;
                board[row][col]=2;
                r=row;
                c=col;
                //player 2 to board[row][col]
            }
                
        }
        return(""+ r +","+ c+".");
        
    }
    public int whosTurn()
    {
        if(singlePlayer==true)
        {
            if(turn%2==0)
            {
                compComp();
                return 2;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            if(turn%2==0)
            {
                return 2;
            }
            else
            {
                return 1;
            }
        }   
    }
    public void boardReset()
    {
        for(int i=0; i<board.length;i++)
        {
            for(int j=0; j<board[i].length;j++)
            {
                board[i][j]=0;
            }
        }
        
    }
    
    public String getWinner()
    {
    	if(winner != null)
    		return winner;
    	else
    		return "null";
    }
    public int[] getData()
    {
        int[] data = new int[3];
        data[0]=score1;
        data[1]=score2;
        data[2]=gamesLeft;
        return data;
        
    }
    public void setRemain(int charles)
    {
        gamesLeft= charles;
    }
    public void nuke()
    {
        boardReset();
        score1=0;
        score2=0;
        gamesLeft=0;
    }
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

}
