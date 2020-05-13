class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        boolean res = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(words[0] == board[i][j]){
                    visited[i][j] = true;
                    res |= helper(visited, board, i, j, words, 1);
                    if(res){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    public boolean helper(boolean[][] visited, char[][] board, int i, int j, char[] words, int index){
        if(index == words.length)    return true;
        boolean res = false;
        // right
        if(j + 1 < board[0].length && board[i][j + 1] == words[index] && visited[i][j + 1] == false){
            visited[i][j + 1] = true;
            res |= helper(visited, board, i, j + 1, words, index + 1);
            if(res) return true;
            visited[i][j + 1] = false;
        }
        //left
        if(j - 1 >=0 && board[i][j - 1] == words[index] && visited[i][j - 1] == false){
            visited[i][j - 1] = true;
            res |= helper(visited, board, i, j - 1, words, index + 1);
            if(res) return true;
            visited[i][j - 1] = false;
        }
        //up
        if(i - 1 >=0 && board[i - 1][j] == words[index] && visited[i - 1][j] == false){
            visited[i - 1][j] = true;
            res |= helper(visited, board, i - 1, j, words, index + 1);
            if(res) return true;
            visited[i - 1][j] = false;
        }
        //down
        if(i + 1 < board.length && board[i + 1][j] == words[index] && visited[i + 1][j] == false){
            visited[i + 1][j] = true;
            res |= helper(visited, board, i + 1, j, words, index + 1);
            if(res) return true;
            visited[i + 1][j] = false;
        }
        return false;
    }
}