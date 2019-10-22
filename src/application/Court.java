package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Court extends BasketballGame{
	public Court(int x, int y,int width,int height){
		super(x,y,width,height, new Image("Court.jpg",true),new ImageView());
		((ImageView)imageView).setImage((Image)image);
		((ImageView)imageView).setX(x);
		((ImageView)imageView).setY(y);
		((ImageView)imageView).setFitWidth(width);
		((ImageView)imageView).setFitHeight(height);
		getChildren().add(((ImageView)imageView));
	}
}
