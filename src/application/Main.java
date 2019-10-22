package application;
	
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	double sceneX, sceneY;
	double transX, transY;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,400);
			BasketballGame[] store = new BasketballGame[3];
			store[0] = new Court(0,0,500,500);
			store[1] = new BasketballHook(140,10,100,100);
			store[2] = new Basketball(100,100,40,40);
			
			for(BasketballGame o: store){
				root.getChildren().add(o);
				final BasketballGame e = o;
				if(o instanceof Basketball){
					o.addEventFilter(MouseEvent.MOUSE_PRESSED,
							new EventHandler<MouseEvent>(){
	
								@Override
								public void handle(MouseEvent t) {
									// TODO Auto-generated method stub
									sceneX = t.getSceneX();
									sceneY = t.getSceneY();
									transX = ((BasketballGame)t.getSource()).getTranslateX();
									transY = ((BasketballGame)t.getSource()).getTranslateY();
								}});
					o.addEventFilter(MouseEvent.MOUSE_DRAGGED, 
							new EventHandler<MouseEvent>(){
	
								@Override
								public void handle(MouseEvent event) {
									// TODO Auto-generated method stub
									double offsetX = event.getSceneX() - sceneX;
									double offsetY = event.getSceneY() - sceneY;
									double newTX = transX + offsetX;
									double newTY = transY + offsetY;
									
									((BasketballGame)event.getSource()).setTranslateX(newTX);
									((BasketballGame)event.getSource()).setTranslateY(newTY);
									
										
								}});
					o.addEventFilter(MouseEvent.MOUSE_RELEASED, 
							new EventHandler<MouseEvent>(){
	
								@Override
								public void handle(MouseEvent m) {
									// TODO Auto-generated method stub
									TranslateTransition tt= new TranslateTransition(Duration.millis(2000),e);
									tt.setByY(300f);
									tt.setCycleCount(1);
									tt.setAutoReverse(false);
									tt.play();
								}});
				}
			}
			
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
