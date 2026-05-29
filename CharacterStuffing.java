import java.util.Scanner;

class CharacterStuffing {
    public static void main(String args[]) {
        Scanner k = new Scanner(System.in);
        
        // Step 1: Take input
        System.out.println("Enter the string:");
        String s = k.nextLine();
        
        // Step 2: Define special characters
        String flag = "DLESTX";  // Starting Flag
        String endFlag = "DLEETX";  // Ending Flag
        String stuffedData = flag;  // Initialize with starting flag

        // Step 3: Perform Character Stuffing
        for (int i = 0; i < s.length(); i++) {
            // If "DLE" appears in input, stuff another "DLE" before it
            if (s.startsWith("DLE", i)) {
                stuffedData += "DLE";
            }
            // Add current character
            stuffedData += s.charAt(i);
        }

        // Step 4: Append Ending Flag
        stuffedData += endFlag;

        // Step 5: Output Results
        System.out.println("Original Data: " + s);
        System.out.println("Transmitted Data (Character Stuffed): " + stuffedData);
    }
}
