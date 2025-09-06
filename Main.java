import java.util.Scanner;

class Book {
    String isbn;
    String orderCode;
    String title;
    String date_borrowed;
    boolean isReturned;

    //template para mag add ng mga books
    Book(String isbn, String orderCode, String title, boolean isReturned, String date) {
        this.isbn = isbn;
        this.orderCode = orderCode;
        this.title = title;
        this.isReturned = isReturned;
        this.date_borrowed = date;
    }

}

public class Main {
    public static void main(String[] args) {
        String user = "Wion Andrei D. Villareal";
        String lib_id = "917273-A";

        Scanner userInput = new Scanner(System.in);

        //hardcoded na library data
        Book[] books = {
                new Book("9780451524935", "ORD001", "1984", false, "September 2, 2026"),
                new Book("9780061122415", "ORD002", "The Alchemist", false, "August 2, 2026"),
                new Book("9780547928227", "ORD003", "The Hobbit", true, "May 1, 2026"),
                new Book("9780451526342", "ORD004", "Animal Farm", true, "February 16, 2026"),
                new Book("9780061120084", "ORD006", "To Kill a Mockingbird", true, "July 27, 2026"),
            };

        System.out.println("==========LIBRARY MANAGEMENT SYSTEM==========");
        System.out.println("\t\tReturning of Book.\n");

        System.out.println("Library ID: " + lib_id);
        System.out.println("Current user: " + user + "\n");

        System.out.println("========== BORRWED BOOKS ==========");
        for (Book b : books) {
            System.out.println("Book title: " + b.title);
            System.out.println("ISBN: " + b.isbn);
            System.out.println("Order code: " + b.orderCode);
            System.out.println("Borrow date: " + b.date_borrowed);
            System.out.println("Status: " + ((b.isReturned == false) ? "Not returned" : "Returned") );
            System.out.println();
        }


        System.out.print("Enter ISBN: ");
        String isbnInput = userInput.nextLine();
        System.out.print("Enter order code: ");
        String orderCodeInput = userInput.nextLine();

        //dito gumawa tayo variable na walang laman para maging container ng book base sa user input
        Book matchedBook = null;

        //nagloloop sa bawat library data
        for (Book book : books) {
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
        } else {
            System.out.println("Sorry no book matched or its not yet returned.");
            String[] a = {""};
            main(a);
        }



        // ask user if they want to add a rating/review
        System.out.print("Do you want to give the book a rating and review? \n(Y|y or N|n)");
        String give_review = userInput.nextLine();

        if (give_review.equals("Y") || give_review.equals("y")) {
            int rating = 6;

            do {
                System.out.print("Rate the book (1/5): ");
                rating = userInput.nextInt();
                userInput.nextLine();
            } while(rating < 1 || rating > 5);

            System.out.print("Write your review: ");
            String review = userInput.nextLine();

            System.out.println("\nYour review has been submitted!\n\n==========Book Review Summary==========\n\nTitle: "+ matchedBook.title + "\nRatings: "+ rating + "/5\nReview: " + review + "\n\n=========================");
        }

        System.out.println("\nThank you for returning the book!");

        userInput.close();
    }
}