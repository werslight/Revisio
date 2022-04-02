package etu.unice.revisio;

import java.util.ArrayList;

public class ListOfCategory extends ArrayList<Category> {
    public ListOfCategory() {
        ArrayList<File> file1 = new ArrayList<>();
        file1.add(new File("fiche 1 ", 0));

        ArrayList<File> file2 = new ArrayList<>();
        file2.add(new File("fiche 2 ", 0));


        ArrayList<File> file3 = new ArrayList<>();
        file3.add(new File("fiche 2 ", 0));

        add(new Category("Category 1", 2, file1));
        add(new Category("Category 2", 2, file2));
        add(new Category("Category 3", 2, file3));
    }
}
