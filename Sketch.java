import processing.core.PApplet;
import processing.core.PImage;

/**
 * draws randomness
 * @author George D.
 *
 */

public class Sketch extends PApplet {
  PImage imgBackground;
  PImage imgHedgehog;
  PImage imgBug;
  int intCounter;
  // Declare Variables
  int intHedgeX;
  int intBugX;
  int intBugY;
  int intBugSpdX;
  int intBugSpdY;
  int intEllipseRotation;
  
  public void settings() {
    size(1200, 800);
  }

  public void setup() {
    background(210, 255, 173);
    imgBackground = loadImage("randomBg1.png");
    imgHedgehog = loadImage("hedge1.png");
    imgBug = loadImage("bug1.png");
    intCounter = 0; //initiallizes variable
    intBugX = 0;
    intBugY = 0;
    intBugSpdX = 20;
    intBugSpdY = 23;
    intEllipseRotation = 0;
  }

  public void draw() {
    image(imgBackground, 0, 0);
    fill(124, 202, 60);
    rect(0, 650, width, 150);
    translate(600, 400);
    intCounter++; // updates counter
        // makes hedgehog move left and right in sinoiudal pattern
    intHedgeX = (int)(sin(intCounter % 360 * PI / 180) * width / 2.2 - 50);
    // draws hedgehog so it moves in a parabola
    image(imgHedgehog, intHedgeX, (int)((intHedgeX - 240.) * (intHedgeX + 370.) * (1. / 600)) - 150);

    // changes direction when approaches walls
    if (intBugX + intBugSpdX > 570 || intBugX + intBugSpdX < -600){
      intBugSpdX *= -1;
    }
    if (intBugY + intBugSpdY > 350 || intBugY + intBugSpdY < -400){
      intBugSpdY *= -1;
    }
    intBugX += intBugSpdX;
    intBugY += intBugSpdY;
    image (imgBug, intBugX, intBugY);
    
    rotate(PI/16 * (intEllipseRotation % 32));
    intEllipseRotation++; //updates ellipse rotation
    
    ellipse(0, 100, 70, 30);
  }

}