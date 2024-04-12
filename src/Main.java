import java.util.List;

public class Main {

    public static void main (String[] args){
        ElectionSystem system = new ElectionSystem();

        String[] candidates = {"Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train", "Anya Stroud"};
        int p = 5;

        system.initialize(List.of(candidates), p);

        system.castVote("Cole Train");
        system.castVote("Cole Train");
        system.castVote("Marcus Fenix");
        system.castVote("Anya Stroud");
        system.castVote("Anya Stroud");

        // Top 3 candidates after initial votes
        System.out.println("Top 3 candidates after 5 votes: " + system.getTopKCandidates(3));

        //system.auditElection();

        // Top 3 candidates after rigging the election
        system.rigElection("Marcus Fenix");
        System.out.println("Top 3 candidates after rigging the election: " + system.getTopKCandidates(3));

        // Audit the election
        System.out.println("Audit:");
        system.auditElection();

        // EC
        System.out.println("\nEC:");
        system.executeElection();
    }
}
