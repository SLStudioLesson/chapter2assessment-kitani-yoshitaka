package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
        // レシピファイルにデータが入っている場合実行
        if (fileHandler.readRecipes().size() != 0) {
            String[] recipes;

            //メソッドの初期表示処理
            System.out.println("\nRecipes:");
            System.out.println("-----------------------------------");
            // レシピデータの整形・表示処理
            for (int i = 0; i < fileHandler.readRecipes().size(); i++) {
                recipes = fileHandler.readRecipes().get(i).split(",");
                System.out.println("Recipe Name: " + recipes[0]);
                System.out.print("Main Ingredients: " + recipes[1]);
                    // 材料の2つ目以降を表示する処理
                    for (int j = 2; j < recipes.length; j++) {
                        System.out.print("," + recipes[j]);
                    }
                // メソッドの最終表示処理
                System.out.println("\n-----------------------------------");
            }
        // レシピファイルにデータが入っていない場合実行
        } else {
            // レシピデータが取得できなかったことを表示
            System.out.println("No recipes available.");
        }
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        // 標準入力準備
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // レシピ名入力受付処理
        System.out.print("\nEnter recipe name: ");
        String inputRecipeName = reader.readLine();
        // 材料名入力受付処理
        System.out.print("Enter main ingredients (comma separated): ");
        String inputIngredients = reader.readLine();
        // レシピデータ登録メソッド呼び出し
        fileHandler.addRecipe(inputRecipeName, inputIngredients);

    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}

