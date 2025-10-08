import java.util.Scanner;

public class ConsoleInterface { 
    private enum State {
        MAIN_MENU,
        IN_ROOM,
        IN_CLOSET,
        IN_SHELF
    }

    private Scanner scanner = new Scanner(System.in);
    private State currentState = State.MAIN_MENU;
    private Room currentRoom;
    private Closet currentCloset;
    private Shelf currentShelf;
    private LibraryManager libraryManager;
    private Book tempBook;

    public ConsoleInterface(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    public void start() {
        while (true) {
            showCurrentMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            handleInput(choice);
        }
    }

    public void handleInput(int choice) {
        try {
            switch (currentState) {
                case MAIN_MENU:
                    handleMainMenuInput(choice);
                    break;
                case IN_ROOM:
                    handleRoomInput(choice);
                    break;
                case IN_CLOSET:
                    handleClosetInput(choice);
                    break;
                case IN_SHELF:
                    handleShelfInput(choice);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void handleMainMenuInput(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Введите ID комнаты: ");
                int roomId = scanner.nextInt();
                Room room = libraryManager.findRoomById(roomId);
                enterRoom(room);
                break;
            case 2:
                System.out.println("Введите ID книги: ");
                int bookId = scanner.nextInt();
                tempBook = libraryManager.findBookById(bookId);
                System.out.println(tempBook.toString());
                currentState = State.MAIN_MENU;
                break;
            case 3:
                System.out.println("Введите название книги: ");
                String bookTitle = scanner.nextLine();
                tempBook = libraryManager.findBookByTitle(bookTitle);
                System.out.println(tempBook.toString());
                currentState = State.MAIN_MENU;
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private void handleRoomInput(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Введите ID шкафа: ");
                int closetId = scanner.nextInt();
                Closet closet = currentRoom.findClosetById(closetId);
                enterCloset(closet);
                break;
            case 2:
                goBack();
                break;
            case 0:
                currentState = State.MAIN_MENU;
                currentRoom = null;
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private void handleClosetInput(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Введите ID полки: ");
                int shelfId = scanner.nextInt();
                Shelf shelf = currentCloset.findShelfById(shelfId);
                enterShelf(shelf);
                break;
            case 2:
                goBack();
                break;
            case 0:
                currentState = State.MAIN_MENU;
                currentCloset = null;
                currentRoom = null;
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private void handleShelfInput(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Книги на полке:");
                for (Book book : currentShelf.getBooks()) {
                    System.out.println("- " + book);
                }
                break;
            case 2:
                System.out.println("Добавление новой книги");
                System.out.println("Введите название книги: ");
                String newTitle = scanner.nextLine();
                System.out.println("Введите автора книги: ");
                String newAuthor = scanner.nextLine();
                System.out.println("Введите количество страниц в книге: ");
                int newPages = scanner.nextInt();
                Book newBook = new Book(newTitle, newAuthor, newPages);
                this.currentShelf.addBook(newBook);
                currentState = State.IN_SHELF;
                break;
            case 3:
                goBack();
                break;
            case 0:
                currentState = State.MAIN_MENU;
                currentShelf = null;
                currentCloset = null;
                currentRoom = null;
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    public void enterRoom(Room room) {
        currentState = State.IN_ROOM;
        currentRoom = room;
        currentCloset = null;
        currentShelf = null;
    }

    public void enterCloset(Closet closet) {
        currentState = State.IN_CLOSET;
        currentCloset = closet;
        currentShelf = null;
    }

    public void enterShelf(Shelf shelf) {
        currentState = State.IN_SHELF;
        currentShelf = shelf;
    }

    public void goBack() {
        switch (currentState) {
            case IN_SHELF:
                currentState = State.IN_CLOSET;
                currentShelf = null;
                break;
            case IN_CLOSET:
                currentState = State.IN_ROOM;
                currentCloset = null;
                break;
            case IN_ROOM:
                currentState = State.MAIN_MENU;
                currentRoom = null;
                break;
            case MAIN_MENU:
                break;
        }
    }

    public void showCurrentMenu() {
        switch (currentState) {
            case MAIN_MENU:
                showMainMenu();
                break;
            case IN_ROOM:
                showRoomMenu(currentRoom);
                break;
            case IN_CLOSET:
                showClosetMenu(currentCloset);
                break;
            case IN_SHELF:
                showShelfMenu(currentShelf);
                break;
        }
    }

    private void showMainMenu() {
        System.out.println("Добро пожаловать в библиотеку");
        System.out.println("1. Выбрать комнату");
        System.out.println("2. Найти книгу по ID");
        System.out.println("3. Найти книгу по названию");
        System.out.println("4. Выход");
    }

    private void showRoomMenu(Room room) {
        System.out.println("Комната " + room.getRoomId());
        System.out.println("1. Выбрать шкаф");
        System.out.println("2. Назад");
        System.out.println("0. В главное меню");
    }

    private void showClosetMenu(Closet closet) {
        System.out.println("Шкаф " + closet.getClosetId());
        System.out.println("1. Выбрать полку");
        System.out.println("2. Назад");
        System.out.println("0. В главное меню");
    }

    private void showShelfMenu(Shelf shelf) {
        System.out.println("Полка " + shelf.getShelfId());
        System.out.println("1. Показать книги");
        System.out.println("2. Добавить книгу на полку");
        System.out.println("3. Назад");
        System.out.println("0. В главное меню");
    }
}
