package org.howard.edu.lsp.midterm.question3;

public class VotingMachineTest {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates
        vm.addCandidate("Alice");// (2.5 pts.)
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes
        vm.castVote("Alice");// 	(5 pts.)
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");// (2.5 pts.)
        System.out.println("Vote for Eve successful? " + success);

        // Displays Each Candidiates Votes
        vm.DisplayVoteCounts();

        // Displays the Winner
        System.out.println("Winner: " + vm.getWinner());// (5 pts.)
        

        //Output: Charlie WINS with 3 votes!!
    
    }

}
