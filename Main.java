package project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Candidate {
    private String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void vote() {
        votes++;
    }
}

class VotingSystem {
    private Map<String, Candidate> candidates;
    private Map<String, Boolean> voters;

    public VotingSystem() {
        candidates = new HashMap<>();
        voters = new HashMap<>();
        initializeCandidates();
    }

    private void initializeCandidates() {
    	candidates.put("C#", new Candidate("C#"));
    	candidates.put("C++", new Candidate("C++"));
        candidates.put("Java", new Candidate("Java"));
        candidates.put("Phython", new Candidate("Phython"));
        candidates.put("Javascript", new Candidate("Javascript"));
        candidates.put("SQL", new Candidate("SQL"));
        
    }

    public void displayCandidates() {
        System.out.println("Candidates:");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getName());
        }
    }

    public void vote(String candidateName, String voterId) {
        if (voters.containsKey(voterId)) {
            System.out.println("You have already voted. One vote per person.");
        } else if (candidates.containsKey(candidateName)) {
            Candidate candidate = candidates.get(candidateName);
            candidate.vote();
            voters.put(voterId, true);
            System.out.println("Vote cast successfully for " + candidateName);
        } else {
            System.out.println(" Please choose a valid candidate.");
        }
    }

    public void displayResults() {
        System.out.println("Voting Results:");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getName() + ": " + candidate.getVotes() + " votes");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("WELCOME TO THE VOTING COMPETITION FOR PROGRAMMIG LANGUAGES");


        while (true) {
        	        	
            System.out.println("\n1. Display Candidates");
            System.out.println("2. Vote");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    votingSystem.displayCandidates();
                    break;
                case 2:
                    System.out.print("Enter the candidate's name that you wish to support: ");
                    String candidateName = scanner.next();
                    System.out.print("Enter your voter ID: ");
                    String voterId = scanner.next();
                    votingSystem.vote(candidateName, voterId);
                    break;
                case 3:
                    votingSystem.displayResults();
                    break;
                case 4:
                    System.out.println("Thank you");
                    System.exit(0);
                default:
                    System.out.println("Please try again; this selection is invalid");
            }
        }
    }
}

