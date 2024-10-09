package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))){
            // ファイル読み込みの準備
            ArrayList<String> array = new ArrayList<>(); // レシピデータ(戻り値)
            String line = ""; // 標準入力の格納先

            // レシピデータの読み込みと格納処理
            while((line = fileReader.readLine()) != null){
                array.add(line);
            }
            return array;

        } catch (IOException e) {
            // IOExceptionが発生したときエラーメッセージを表示
            System.out.println("Error reading file:" + e.getMessage());
        }
        return null;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            // ファイルに受け取ったレシピデータと材料データを書き込む処理
            writer.write(recipeName + "," + ingredients);
            writer.newLine();
            // 書き込み成功表示
            System.out.println("Recipe added successfully.");

        } catch (IOException e) {
            // IOExceptionが発生したときエラーメッセージを表示
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
