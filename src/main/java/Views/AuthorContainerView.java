/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.AuthorContainerController;
import Models.*;

import java.util.List;
import java.util.Scanner;

/**
 * @author Алескандр
 */
public class AuthorContainerView {
    private AuthorContainerController aCC;//пока так. разберусь с событиями - перепилю.вроде как контрллер должен слушать то что мы во view посылаем

    public AuthorContainerView(AuthorContainerController aCC) {
        this.aCC = aCC;
    }

    public void mainLoop() {
        Scanner in = new Scanner(System.in);
        boolean menuState = false;
        while (true) {
            viewMenu(menuState);
            if (menuState) {
                String inp = in.nextLine();
                char fsymb = inp.charAt(0);
                switch (fsymb) {
                    case '1':
                        viewBooks();
                        break;//view books
                    case '2':
                        viewAuthors();
                        menuState = false;
                        break;//view authors and switch to author edit
                    case '3':
                        addBook(in);
                        break;//add book
                    case '4':
                        deleteBook(in);
                        break;//delete book
                    case '5':
                        editBook(in);
                        break;//edit book
                }
                if (fsymb == 'q') break;
            } else {
                String inp = in.nextLine();
                char fsymb = inp.charAt(0);
                switch (fsymb) {
                    case '1':
                        viewBooks();
                        menuState = true;
                        break;//view books and switch to book edit
                    case '2':
                        viewAuthors();
                        break;//view authors 
                    case '3':
                        addAuthor(in);
                        break;//add author
                    case '4':
                        deleteAuthor(in);
                        break;//delete author
                    case '5':
                        editAuthor(in);
                        break;//edit author
                }
                if (fsymb == 'q') break;
            }

            /*System.out.println("Чтобы продолжить введите 0.");
            while(in.nextLine().charAt(0) != '0') {
                System.out.println("Чтобы продолжить введите 0.");
            }*/
        }
    }

    private void viewBooks() {
        System.out.printf("%45s%n", "=============== Список книг ===============");
        int id = 0;
        for (int j = 0; j < aCC.getAuthorsContainer().getAuthors().size(); j++) {
            List<Book> tempB = aCC.getAuthorsContainer().getAuthors().get(j).getBooks();
            for (int i = 0; i < tempB.size(); i++) {
                System.out.printf("%5d %25s %15s\n", id++, tempB.get(i).getTitle(), tempB.get(i).getAuthor().getName());
            }
        }
        System.out.println();
    }

    private void viewAuthors() {
        System.out.printf("%20s%n", "=============== Список авторов ===============");
        List<Author> tempA = aCC.getAuthorsContainer().getAuthors();
        for (int i = 0; i < tempA.size(); i++) {
            System.out.printf("%5d %15s\n", i, tempA.get(i).getName());
        }
    }

    private void viewMenu(boolean menustate) {
        //menustate = true - MAIN MENU, else - AUTHOR EDIT MENU
        if(menustate) {
            System.out.println("Главное меню\n================");
            System.out.println("1. Список книг");
            System.out.println("2. Список авторов");
            System.out.println("3. Добавить книгу");
            System.out.println("4. Удалить книгу");
            System.out.println("5. Изменить книгу");
            System.out.println("q. Завершить работу программы");
        } else {
            System.out.println("Управление авторами\n================");
            System.out.println("1. Список книг");
            System.out.println("2. Список авторов");
            System.out.println("3. Добавить автора");
            System.out.println("4. Удалить автора");
            System.out.println("5. Изменить автора");
            System.out.println("q. Завершить работу программы");
        }
        System.out.println();
        System.out.print("Введите пункт меню: ");
    }

    private void addBook(Scanner in) {
        System.out.print("Введите название книги: ");
        String name = in.nextLine();
        viewAuthors();
        System.out.printf("%5d %15s\n", aCC.getAuthorsContainer().getAuthors().size(), "Добавить автора");
        int id = new Integer(in.nextLine());
        Book tempB;
        if (id < aCC.getAuthorsContainer().getAuthors().size()) {
            tempB = new Book(name, aCC.getAuthorsContainer().getAuthors().get(id), 0, "", "");
            aCC.addBook(tempB, id);
        } else if (id == aCC.getAuthorsContainer().getAuthors().size()) {
            addAuthor(in);
            tempB = new Book(name, aCC.getAuthorsContainer().getAuthors().get(id), 0, "", "");
            aCC.addBook(tempB, id);
        }
    }

    private void addAuthor(Scanner in) {
        System.out.print("Введите имя автора: ");
        String name = in.nextLine();
        aCC.addAuthor(new Author(name));
    }

    private void deleteAuthor(Scanner in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editAuthor(Scanner in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editBook(Scanner in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void deleteBook(Scanner in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}