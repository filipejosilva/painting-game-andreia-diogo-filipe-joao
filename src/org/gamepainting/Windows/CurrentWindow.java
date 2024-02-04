package org.gamepainting.Windows;

import org.gamepainting.Background;

import java.io.IOException;

public class CurrentWindow {
    private Window window;

    public CurrentWindow(){
        Background background = new Background();
        this.window = new Menu(background, this);
    }
    public void changeScreen() throws InterruptedException, IOException {
        window.changeWindow();
    }

    public void setWindow(Window window){
        this.window = window;
    }
    public Menu getWindow(){
        return (Menu) window;
    }
}
