import java.util.Scanner;

class Book {
    String isbn;
    String orderCode;
    String title;
    boolean isReturned;

    //template para mag add ng mga books
    Book(String isbn, String orderCode, String title, boolean isReturned) {
        this.isbn = isbn;
        this.orderCode = orderCode;
        this.title = title;
        this.isReturned = isReturned;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //hardcoded na library data
        Book[] books = {
                new Book("9780451524935", "ORD001", "1984", false),
                new Book("9780061122415", "ORD002", "The Alchemist", false),
                new Book("9780547928227", "ORD003", "The Hobbit", true),
                new Book("9780451526342", "ORD004", "Animal Farm", true),
                new Book("9780439023528", "ORD005", "The Hunger Games", false),
                new Book("9780061120084", "ORD006", "To Kill a Mockingbird", true),
                new Book("9780316769488", "ORD007", "The Catcher in the Rye", false),
                new Book("9780743273565", "ORD008", "The Great Gatsby", true),
                new Book("9780140268867", "ORD009", "The Odyssey", true),
                new Book("9780140177398", "ORD010", "Of Mice and Men", false)
            };

        System.out.println("==========LIBRARY MANAGEMENT SYSTEM==========\n     Submit a review for returned books.\n");
        System.out.print("Enter ISBN: ");
        String isbnInput = userInput.nextLine();
        System.out.print("Enter order code: ");
        String orderCodeInput = userInput.nextLine();

        //dito gumawa tayo variable na walang laman para maging container ng book base sa user input
        Book matchedBook = null;

        //nagloloop sa bawat library data
        for(Book book : books) {
            if(book.isbn.equals(isbnInput) && book.orderCode.equalsIgnoreCase(orderCodeInput)) {
                if(!book.isReturned){
                    System.out.print("Would you like to return the book? (y/n): ");
                    String answer = userInput.nextLine();

                if(answer.equalsIgnoreCase("y")) {
                    //nilagay natin sa matchedBook yung specific book na nagmatch sa userinput na isbn at order code
                    matchedBook = book;
                    matchedBook.isReturned = true;
                    break;
                } else {
                    break;
                }} else {
                     //same rin nilagay natin sa matchedBook yung specific book na nagmatch
                    matchedBook = book;
                }
                
                break;
            }
        }

        //kung may laman na yung matchedBook variable magrarun
        if(matchedBook != null) {
            System.out.println("\n==========Found Book==========\n\nFound Book: " + matchedBook.title + "\nISBN: " + matchedBook.isbn + "\nReturned: " + matchedBook.isReturned);
            
            int rating = 6;
            //dapat ay 1-5 lang
            do {
                System.out.print("Rate the book (1/5): ");
                rating = userInput.nextInt();
                userInput.nextLine();
            } while(rating < 1 || rating > 5);

            System.out.print("Write your review: ");
            String review = userInput.nextLine();

            //end ng ui
            System.out.println("\nYour review has been submitted!\n\n==========Book Review Summary==========\n\nTitle: "+ matchedBook.title + "\nRatings: "+ rating + "/5\nReview: " + review + "\n\n=========================");

        } else {
            //walang nag match na book base sa userinput
            System.out.println("Sorry no book matched or its not yet returned.");
        }

        userInput.close();
    }
}