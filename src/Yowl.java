import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Yowl {

    public static Scanner scanner = new Scanner(System.in);
    public static Review review = new Review();

    public static void main(String[] args) {
        try {
           review = loadReview();
        } catch (FileNotFoundException e) {
            System.out.println("No Files Found");
        }
        System.out.println("------------------------------\n" +
                "Welcome To Yowl Restaurant Reviews.\n What Would You Like To Do?\n" +
                " Please Enter The Number Corresponding To What You Want To Do.\n" +
                " 1)Write A Review.\n 2)Update A Review.\n 3)View Last Review.");

        String option = scanner.nextLine();
        switch (option) {
            case "1":
                writeReview();
                break;
            case "2": {
                System.out.println("Which Field Would You Like To Update?\n " +
                        "Please Enter The Number Corresponding To What You Would Like To Do." +
                        "\n 1)Restaurant Name\n 2)Date\n 3)Your Review\n" +
                        " 4)Your Rating\n 5)Recommendation");
                String option2 = scanner.nextLine();
                boolean changed = false;
                switch (option2) {
                    case "1":
                        System.out.println("What Is The Name Of The Restaurant You Would Like To Review?");
                        String rName = scanner.nextLine();
                        review.setRestaurantName(rName);
                        changed = true;
                        break;
                    case "2":
                        System.out.println("When Did Your Last Experience Occur?\n Please Use MM/DD/YEAR Format");
                        String rDate = scanner.nextLine();
                        review.setDate(rDate);
                        changed = true;
                        break;
                    case "3":
                        System.out.println("What Was Your Experience Like?");
                        String rExp = scanner.nextLine();
                        review.setExperience(rExp);
                        changed = true;
                        break;
                    case "4":
                        System.out.println("How Would You Rate Your Experience 1-10");
                        String rRating = scanner.nextLine();
                        int i = Integer.parseInt(rRating);
                        review.setRating(i);
                        changed = true;
                        break;
                    case "5":
                        System.out.println("Would You Recommend This Restaurant To Friends");
                        String rRec = scanner.nextLine();
                        review.setRecommend(rRec);
                        changed = true;
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }

                if (changed) {
                    File newReview = new File("yowlReview.json");
                    JsonSerializer serializer = new JsonSerializer();
                    String json = serializer.serialize(review);
                    try {
                        FileWriter fw = new FileWriter(newReview);
                        fw.append(json);
                        fw.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            break;

            case "3":
                try {
                    review = loadReview();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }



    public static Review loadReview() throws FileNotFoundException {
        File f = new File("yowlReview.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        s.close();

        JsonParser p = new JsonParser();
        Review review1 = p.parse(contents, Review.class);
        System.out.println(review1);
        return p.parse(contents, Review.class);


    }

    public static void writeReview() {
        System.out.println("What Is The Name Of The Restaurant You Would Like To Review?");
        String rName = scanner.nextLine();
        review.setRestaurantName(rName);
        System.out.println("When Did Your Last Experience Occur?\n Please Use MM/DD/YEAR Format");
        String rDate = scanner.nextLine();
        review.setDate(rDate);
        System.out.println("What Was Your Experience Like?");
        String rExp = scanner.nextLine();
        review.setExperience(rExp);
        System.out.println("How Would You Rate Your Experience 1-10");
        String rRating = scanner.nextLine();
        int i = Integer.parseInt(rRating);
        review.setRating(i);
        System.out.println("Would You Recommend This Restaurant To Friends");
        String rRec = scanner.nextLine();
        review.setRecommend(rRec);


        File newReview = new File("yowlReview.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(review);

        try {
            FileWriter fw = new FileWriter(newReview);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            System.out.println("Sorry, Your Input Is Not Correct.");
        }
    }

}

