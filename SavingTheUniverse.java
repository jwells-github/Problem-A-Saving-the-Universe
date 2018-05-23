import java.util.*;

public class SavingTheUniverse {

  private static int saveTheUniverse(ArrayList<String> searchEngines, ArrayList<String> searches){

    // Keeps a list of the search engines that have been used for each loop
    String[] searchEnginesUsed = new String[searchEngines.size()];
    int numOfEnginesUsed = 0;
    int changes = 0;

    // Progress through the given list of search terms
    for(int i =0; i < searches.size(); i++){
      boolean usedAlready = false;
      
      // Check if the current search term has been used before
      for(String s : searchEnginesUsed){
        if (searches.get(i).equals(s)){
          usedAlready = true;
        }
      }

      // if the search term has not been used before, 
      // add it to the list of used search engines 
      // and increment the numOfEnginesUsed by one
      if (usedAlready == false){
        searchEnginesUsed[numOfEnginesUsed] = searches.get(i);
        numOfEnginesUsed ++;
        // if all search engines have been searched we can assume a change was neccesary
        if (numOfEnginesUsed == searchEnginesUsed.length){
          // Move back one position in the list because
          // a search engine can not search itself
          i--;
          changes ++;
          numOfEnginesUsed = 0;

          // Reset the list of searches used
          for(int j = 0; j < searchEnginesUsed.length; j++){
            searchEnginesUsed[j] = "";
          }
        }
        
      }
    }
    return changes;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int testCases = scanner.nextInt();


    for(int i = 0; i < testCases; i++ ){
      ArrayList<String> searchEngines = new ArrayList<String>();
      ArrayList<String> searches = new ArrayList<String>();

      int numSearchEngines = scanner.nextInt();
      scanner.nextLine();

      for(int j = 0; j < numSearchEngines; j++){
        searchEngines.add(scanner.nextLine());
      }
      int numSearches = scanner.nextInt();
      scanner.nextLine();

      for(int j = 0; j < numSearches; j++){
        searches.add(scanner.nextLine());
      }
      System.out.println("Case #" + (i+1) + ": " +saveTheUniverse(searchEngines,searches));
    }
    scanner.close();
  }
}
