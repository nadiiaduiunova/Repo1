package com.mycompany.app;

public class App {
    public static void main( String[] args ){
        LazySingleton.getDriver().get("https://google.com");
        String title = LazySingleton.getDriver().getTitle();
        System.out.println(title);
        LazySingleton.resetSession();
        System.out.println( "Hello World!" );

    }
}
