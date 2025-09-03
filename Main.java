import java.util.Scanner;

class Book {
        String isbn;
        String orderCode;
        String title;
        boolean isReturned;

        Book(String isbn, String orderCode, String title, boolean isReturned) {
            this.isbn = isbn;
            this.orderCode = orderCode;
            this.title = title;
            this.isReturned = isReturned;
        }
    }

public class Main {
    public static void main (String args[]) {
         Scanner userInput = new Scanner(System.in);

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

       
        System.out.println("\n==========Library Book Review System==========\n Submit a review for the returned books\n");
        System.out.print("Enter ISBN: ");
        String isbnInput = userInput.nextLine();
        System.out.print("Enter Order Code: ");
        String orderCodeInput = userInput.nextLine();

        Book matchedBook = null;
        for(Book book: books) {
            if(book.isbn.equals(isbnInput) && book.orderCode.equals(orderCodeInput)) {
                if(book.isReturned) {
                    matchedBook = book;
                    break;
                } else {
                    System.out.print("The book is not yet returned, would you like to return it? (y/n): ");
                    String willReturnBook = userInput.nextLine();

                    if(willReturnBook.equalsIgnoreCase("y")) {
                        matchedBook = book;
                        matchedBook.isReturned = true;
                        System.out.println("Thank you for returning the book!");
                        break;
                    } else {
                        System.out.println("Sorry, you cant review an unreturned book.");
                        break;
                    }
                }

            }
        }

        if(matchedBook != null) {
                System.out.println("\n\n==========Found Book Match==========\n\nBook found: " + matchedBook.title + "\nISBN: "+ matchedBook.isbn + "\nStatus: Returned");

                //ask for rating
                int bookRating = 6;
                do {
                System.out.print("Please rate the book (1/5):");
                bookRating = userInput.nextInt();
                userInput.nextLine();// handle newline issue
                } while (bookRating < 1 || bookRating > 5);

                System.out.println("Write your review: ");
                String bookReview = userInput.nextLine();

                System.out.println("\n\nYour review has been submitted!\n\n==========Review Summary==========\n\nBook Title: " + matchedBook.title + "\nRating: " + bookRating + "/5\nReview: " + bookReview + "\n\n===================================");
            } else {
                System.out.println("Sorry no book match your ISBN and order code");
            }

            userInput.close();

    }
}