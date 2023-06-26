package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import modele.Unitemodele;

import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Unite  {


	//Attributes //
    private BufferedImage img;
    private Unitemodele um;
    

    //Contractor //
    public Unite(Unitemodele um,BufferedImage im )
    {
       this.img= im;
       this.um = um;
    }

    //Methodes //
    
    //Methode qui reourne l'image de l'unite //
    /**
	 * @return BufferedImage
	 */
    private  BufferedImage painIcon(){
        return um.Afficheimg();
    }

	
}
