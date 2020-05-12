package com.kodilla.game.userinterface;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public interface UserInterfaceContent {

    String backgroundMainView = "file:kodilla-game/src/main/resources/BackGround/background.jpg";
    Image BACKGROUND_MAIN_VIEW = new Image(backgroundMainView);

    String field = "file:kodilla-game/src/main/resources/Pawns/field80x80.png";
    Image FIELD = new Image(field);
    
    String ypHomeBaseStart = "file:kodilla-game/src/main/resources/HomesBasesStartPoint/blue80x80.png";
    String bpHomeBaseStart = "file:kodilla-game/src/main/resources/HomesBasesStartPoint/green80x80.png";
    String gpHomeBaseStart = "file:kodilla-game/src/main/resources/HomesBasesStartPoint/red80x80.png";
    String rpHomeBaseStart = "file:kodilla-game/src/main/resources/HomesBasesStartPoint/yellow80x80.png";

    Image YPHomeBaseStart = new Image(ypHomeBaseStart);
    Image BPHomeBaseStart = new Image(bpHomeBaseStart);
    Image GPHomeBaseStart = new Image(gpHomeBaseStart);
    Image RPHomeBaseStart = new Image(rpHomeBaseStart);

    Image YPHomeBaseStart_RES = new Image(ypHomeBaseStart, 80, 80, false, false);
    Image BPHomeBaseStart_RES = new Image(bpHomeBaseStart, 80, 80, false, false);
    Image GPHomeBaseStart_RES = new Image(gpHomeBaseStart, 80, 80, false, false);
    Image RPHomeBaseStart_RES = new Image(rpHomeBaseStart, 80, 80, false, false);

    String yp = "file:kodilla-game/src/main/resources/Pawns/yellowPawn.png";
    String bp = "file:kodilla-game/src/main/resources/Pawns/bluePawn.png";
    String gp = "file:kodilla-game/src/main/resources/Pawns/greenPawn.png";
    String rp = "file:kodilla-game/src/main/resources/Pawns/redPawn.png";
    Image YP = new Image(yp);
    Image BP = new Image(bp);
    Image GP = new Image(gp);
    Image RP = new Image(rp);
    Image YP_RES = new Image(yp, 60, 60, false, false);
    Image BP_RES = new Image(bp, 60, 60, false, false);
    Image GP_RES = new Image(gp, 60, 60, false, false);
    Image RP_RES = new Image(rp, 60, 60, false, false);
    ImageView YP_RES_IW = new ImageView(YP_RES);
    ImageView BP_RES_IW = new ImageView(BP_RES);
    ImageView GP_RES_IW = new ImageView(GP_RES);
    ImageView RP_RES_IW = new ImageView(RP_RES);

    static String printManual() {
        return "Instrukcja obsługi";
    }

    static String printAbout() {
        return "2020";
    }
}

