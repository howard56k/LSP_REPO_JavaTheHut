package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

public class VotingMachine {
    private Map<String, Integer> voteCounter;

    /**
     * Constructs a VotingMachine Object creating a new counter
     */
    VotingMachine(){
        voteCounter = new HashMap<String, Integer>();
    }

    /**
     * Enters a Candidate's name into the voting machine.
     * @param name the candidate's name.
     */
    public void addCandidate(String name) {
        voteCounter.put(name, 0);
    }

    /**
     * Casts a vote for a given candidate.
     * @param name the candidate's name.
     * @return true if the vote was successful, false if candidate doesn't exist.
     */
    public boolean castVote(String name) {
        //Checks if the Candidate exists to Vote For
        if (!voteCounter.containsKey(name)) {
            return false;
        }
        voteCounter.put(name, voteCounter.get(name) + 1);
        return true;
    }

    /**
     * Determines the winner of the election and Returns a String represenation of the Winner.
     * @return the name of the winning candidate. If there's a tie, returns one of them.
     * Returns the Winner
     */
    public String getWinner() {
        String winner = null;
        int winnerVotes = -1;
        for (Map.Entry<String, Integer> entry : voteCounter.entrySet()) {
            if (entry.getValue() > winnerVotes) {
                winner = entry.getKey();
                winnerVotes = entry.getValue();
            }
        }
        if (winner == null){
            return "There is no Winner.";
        }
        return String.format("Candidate %s WINS with %d votes!!", winner, winnerVotes);
    }

    /**
     * 
     */
    public void DisplayVoteCounts(){
        for (Map.Entry<String, Integer> entry : voteCounter.entrySet()) {
            System.out.println(String.format("Candidate %s has %d votes", entry.getKey(), entry.getValue()));
        }
    }


}
