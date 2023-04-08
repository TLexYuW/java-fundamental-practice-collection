package com.lex.practice.generics.method;


/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023-2023/4/8
 */
public class Main2 {
    public static void main(String[] args) {
        // Example
        /*
        Player player = new Player();
        Enemy enemy = new Enemy();
        Item item = new Item();
        Tree tree = new Tree();
        draw(Player);
        draw(Enemy);
        draw(Item);
        draw(Tree);
         */
    }

    private static <T> void draw(T x) {
        System.out.println("x = " + x);
    }
}
