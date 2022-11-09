import java.util.Scanner;

public class RecordMovies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //добавить фильмы статично
        Movies[] movies = addMovies();

        // добавить фильмы
        // setMovies(sc,movies)
        // вывод всех фильмов
        showMovies(sc, movies);
        // поиск среднего значения стоимости
        double avgRentalCost = findAvgRentalCost(sc, movies);
        // вывод фильмов, стоимость которых выше среднего значения
        showMoviesAvgRentalCostMore(sc, movies, avgRentalCost);
        // поиск самого старого фильма
        int numberOldMovie = findNumberOldMovie(sc, movies);
        // вывод информации про старый фильм
        showMoviesOldMovie(sc, movies, numberOldMovie);
        // сортировка по алфавиту
        alphabeticalSorting(sc, movies);
        //вывод отсортированных фильмов
        System.out.println("Отсортированный массив фильмов:");
        showMovies(sc, movies);
        //организовать поиск по названию, исправление одного из полей и
        //вывод полной информации о фильме после редактирования.
        editingMovie(sc, movies);
        }

    private static Movies[] addMovies() {
        int count = 4;
        Movies[] movies = new Movies[count];
        movies[0] = new Movies("Клаус", 2019, "США", "Комедия", 40);
        movies[1] = new Movies("Интерстеллар", 2014, "США", "Приключения", 20);
        movies[2] = new Movies("Гладиатор", 2000, "США", "Боевик", 10);
        movies[3] = new Movies("Начало ", 2010, "Великобритания", "Фантастика", 30);
        return movies;
    }
    private static void setMovies(Scanner sc, Movies[] movies){

        System.out.print("Введите количество фильмов => ");
        int count = sc.nextInt();
        sc.nextLine();

        // заполнение данных о фильме
        System.out.println("Введите информацию о каждом фильме: ");
        for (int i = 0; i < movies.length; i++){
            movies[i] = new Movies();

           System.out.print("Введите название фильма " + (i + 1) + "  => ");
            movies[i].name = sc.nextLine();

           System.out.print("Введите год " + (i + 1) + " => ");
            movies[i].year = sc.nextInt();

            System.out.print("Введите страну " + (i + 1) + " => ");
            movies[i].country = sc.nextLine();

            System.out.print("Введите жанр " + (i + 1) + " => ");
            movies[i].genre = sc.nextLine();

            System.out.print("Стоимость проката " + (i + 1) + " => ");
            movies[i].rentalCost = sc.nextInt();

            sc.nextLine();
        }
    }

    private static void showMovies(Scanner sc, Movies[] movies) {
        System.out.println("Фильмы:");
        for(int i = 0; i< movies.length; i++){
            System.out.println("\t" + movies[i].name + " \t" + movies[i].year + " \t" +
                    movies[i].country + " \t" + movies[i].genre + " \t" + movies[i].rentalCost);
        }
    }
    private static double findAvgRentalCost(Scanner sc, Movies[] movies) {
        double temp = 0;
        for(int i = 0; i<movies.length; i++){
            temp += movies[i].rentalCost;
        }
        return temp/movies.length;
    }
    private static void showMoviesAvgRentalCostMore(Scanner sc, Movies[] movies, double avgRentalCost){
        System.out.println("Фильмы с ценой больше средней:");

        for(int i = 0; i<movies.length; i++){
            if(avgRentalCost < movies[i].rentalCost){
                System.out.println("\t" + movies[i].name);
            }
        }
    }
    private static int findNumberOldMovie(Scanner sc, Movies[] movies){
        int numberOldMovie = 0;
        int oldMovie= movies[numberOldMovie].year;
        for(int i = 0; i<movies.length; i++){
            if(movies[i].year<oldMovie){
                oldMovie = movies[i].year;
                numberOldMovie = i;
            }
        }
        return numberOldMovie;
    }
    private static void showMoviesOldMovie(Scanner sc, Movies[] movies, int numberOldMovie){
        System.out.println("Самый старый фильм:");
        System.out.println("\t" + movies[numberOldMovie].name + " \t" + movies[numberOldMovie].year + " \t" +
                movies[numberOldMovie].country + " \t" + movies[numberOldMovie].genre + " \t"
                + movies[numberOldMovie].rentalCost);
    }
    private static void alphabeticalSorting(Scanner sc, Movies[] movies){
        for (int i = 0; i < movies.length-1; i++)
            for (int j = 0; j < movies.length-i-1; j++)
                if(movies[j].name.compareTo(movies[j+1].name)>0){
                    Movies rab = movies[j]; //rab – робоча змінна для перестановки
                    movies[j] = movies[j + 1];
                    movies[j + 1] = rab;
                }
    }
    private static void editingMovie(Scanner sc, Movies[] movies){
        int index;
        System.out.print("\nВведите название фильма:");
        String film = sc.nextLine();

        for (int i = 0; i < movies.length; i++){
            if(movies[i].name.equals(film)){
                index = i;

                System.out.println("Выберите что нужно исправить: ");
                System.out.println("1 - Название \n2 - Год \n3 - Страну " + "\n4 - Жанр" +
                        "\n5 - Стоимость проката ");
                System.out.print("");
                int operation = sc.nextInt();
                sc.nextLine();

                switch (operation){
                    case 1:
                        System.out.print("Введите новое название фильма: ");
                        movies[i].name = sc.nextLine();
                        break;
                    case 2:
                        System.out.print("Введите новую дату фильма: ");
                        movies[i].year = sc.nextInt();
                        break;
                    case 3:
                        System.out.print("Введите новый страну фильма: ");
                        movies[i].country = sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Введите новый жанр фильма: ");
                        movies[i].genre = sc.nextLine();
                        break;
                    case 5:
                        System.out.print("Введите новую стоимость проката ");
                        movies[i].rentalCost = sc.nextInt();
                        break;
                    default:
                        System.out.print("Нет такого пункта!");
                        break;
                }

                System.out.println("Обновленная информация про фильм: ");
                System.out.println("\t" + movies[index].name + " \t" + movies[index].year + " \t" +
                        movies[index].country + " \t" + movies[index].genre + " \t" + movies[index].rentalCost);
            }
        }
    }

}
