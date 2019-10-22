package application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BasketballGame extends Group{
	int x;
	int y;
	int width;
	int height;
	Image image;
	ImageView imageView;
	
	public BasketballGame(int x,int y,int width,int height, Image image, ImageView imageView){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image =image;
		this.imageView = imageView;
	}

}
