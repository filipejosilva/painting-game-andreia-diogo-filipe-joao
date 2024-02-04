package org.gamepainting.windows;

import java.io.IOException;

public abstract class Window {
    protected CurrentWindow current;

    public Window(CurrentWindow current){
        this.current = current;
    }

    public abstract void changeWindow() throws InterruptedException, IOException;
}
