package sample;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import sample.util.PTS;

public class MainHrFXController {

    @FXML
    private MenuItem menuDepart;

    @FXML
    private MenuItem menuManage;

    @FXML
    private MenuItem menuSearch;

    @FXML
    private MenuItem menuUpdate;
    
    @FXML
    private MenuItem menuChart;

    @FXML
    private TabPane mainTabPane;
    
    @FXML
    private Tab tab3;

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private Tab tab4;
    
    @FXML
    private Tab tab5;
    
    @FXML
    private BorderPane searchTabBorder;

    @FXML
    private BorderPane empTabBorder;

    @FXML
    private BorderPane depChartBorder;

    @FXML
    private BorderPane debTabBorder;

    @FXML
    private BorderPane updateTabBorder;

    String systemver="HR sample Schema 관리 시스템";

    // 탭을 누르면, 각 탭으로 전환시켜 주는 메서드드
   @FXML
    public void initialize () {
	   tab1.setGraphic(buildImage("sample/image/shared.png"));
   	tab1.setOnSelectionChanged(eee->{
       	if(tab1.isSelected()){
       		System.out.println("tab1------------------------->"+((Tab)eee.getSource()).getId());
       		debTabBorder.setCenter(departView);
       		tab1.setGraphic(buildImage("sample/image/shared_black.png"));
       	}else {
       		tab1.setGraphic(buildImage("sample/image/shared.png"));
       	}
       });
   	tab2.setGraphic(buildImage("sample/image/people.png"));
       tab2.setOnSelectionChanged(eee->{
       	if(tab2.isSelected()){
       		System.out.println("tab2------------------------->"+((Tab)eee.getSource()).getId());
       		empTabBorder.setCenter( emptvView);
       		tab2.setGraphic(buildImage("sample/image/people_black.png"));
       	}else {
       		tab2.setGraphic(buildImage("sample/image/people.png"));
       	}
       });
       tab3.setGraphic(buildImage("sample/image/group_add.png"));
       tab3.setOnSelectionChanged(eee->{
       	if(tab3.isSelected()){
       		System.out.println("tab3------------------------->"+((Tab)eee.getSource()).getId());
       		searchTabBorder.setCenter(empsearchView);
       		tab3.setGraphic(buildImage("sample/image/group_add_black.png"));
       	}else {
       		tab3.setGraphic(buildImage("sample/image/group_add.png"));
       	}
       });
       tab4.setGraphic(buildImage("sample/image/room_preferences.png"));
       tab4.setOnSelectionChanged(eee->{
       	if(tab4.isSelected()){
       		System.out.println("tab4------------------------->"+((Tab)eee.getSource()).getId());
       		updateTabBorder.setCenter(empupdateView);
       		tab4.setGraphic(buildImage("sample/image/room_preferences_black.png"));
       	}else {
       		tab4.setGraphic(buildImage("sample/image/room_preferences.png"));
       	}
       });
       tab5.setGraphic(buildImage("sample/image/addchart.png"));
       tab5.setOnSelectionChanged(eee->{
       	if(tab5.isSelected()){
       		System.out.println("tab5------------------------->"+((Tab)eee.getSource()).getId());
       		depChartBorder.setCenter(piecharview);
				piecharview.refresh();
				tab5.setGraphic(buildImage("sample/image/bar_chart.png"));
	        }else {
	        	tab5.setGraphic(buildImage("sample/image/addchart.png"));
	        }
       });
    }
   
   private static ImageView buildImage(String imgPatch) {
       Image i = new Image(imgPatch);
       ImageView imageView = new ImageView();
       //You can set width and height
       imageView.setFitHeight(16);
       imageView.setFitWidth(16);
       imageView.setImage(i);
       return imageView;
   }
   
    // HR 시작 탭을 누르면 인사 관리 시스템이 시작하는 메서드
    @FXML
    void onStartAction(ActionEvent event) {
    	  Alert alert = new Alert (AlertType.INFORMATION);
          alert.setTitle(systemver);
          alert.setHeaderText("인사 관리 시스템 "+ PTS.toDate3(new Date()));
          alert.setContentText("인사관리시스템은 부서관리, 사원관리, 인사정보를 관리 하는 시스템입니다.");
          
          ImageView icon = new ImageView("sample/image/outline_cloud_circle.png");

          // The standard Alert icon size is 48x48, so let's resize our icon to match
          icon.setFitHeight(40);
          icon.setFitWidth(40);

          // Set our new ImageView as the alert's icon
          alert.setGraphic(icon);
          
          alert.show();
          mainTabPane.setVisible(true);    
    }

    // HR 종료 탭을 누르면 인사 관리 시스템이 종료되는 메서드
    @FXML
    void onExitAction(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle(systemver);
        alert.setHeaderText("인사 관리 시스템("+PTS.toDate3(new Date())+")을 끝내시겠습니까?");
    	alert.setContentText("정말 끝내시겠습니까?");
    	
    	ImageView icon = new ImageView("sample/image/logout_black.png");
        icon.setFitHeight(30);
        icon.setFitWidth(30);
        alert.setGraphic(icon);
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		Platform.exit();
    		//System.exit(0);
    	} else return;
    }

    // About 탭을 누르면 인사 관리 시스템 설명이 나오는 메서드
    @FXML
    void onHelpAction(ActionEvent event) {
    	  Alert alert = new Alert (AlertType.INFORMATION);
          alert.setTitle(systemver);
          alert.setHeaderText("인사 관리 시스템 "+PTS.toDate3(new Date()));
          alert.setContentText(" 안녕하세요 "+systemver+"입니다. "
          		+ "\n 인사관리시스템은 부서관리, 관리자관리, 인사에 관련된 입력/수정을 하는 시스템입니다."
          		+ "\n 실행은 '시작/종료'를 선택하십시오."
          		+ "\n"
          		+ "\n 				JB Corp.");
          
          ImageView icon = new ImageView("sample/image/emoji_people.png");
          icon.setFitHeight(40);
          icon.setFitWidth(40);
          alert.setGraphic(icon);
    }

    // 메뉴에서 각 탭명을 선택하면 탭이 변환되도록 하는 메서드
    @FXML
    void onMenuction(ActionEvent event) {
    	if(event.getSource()==menuDepart){
    		System.out.println("tab1------------------------->");
    		mainTabPane.getSelectionModel().select(tab1);
    		debTabBorder.setCenter(departView);  
    	}else if(event.getSource()==menuManage){
    		System.out.println("tab2------------------------->");
    		mainTabPane.getSelectionModel().select(tab2);
    		empTabBorder.setCenter( emptvView);
    	}else if(event.getSource()==menuSearch){
    		System.out.println("tab3------------------------->");
    		mainTabPane.getSelectionModel().select(tab3);
    		searchTabBorder.setCenter(empsearchView);
    	}else if(event.getSource()==menuUpdate){
    		System.out.println("tab4------------------------->");
    		mainTabPane.getSelectionModel().select(tab4);
    		updateTabBorder.setCenter(empupdateView);
    	}else if(event.getSource()==menuChart){
    		System.out.println("tab5------------------------->");
    		mainTabPane.getSelectionModel().select(tab5);
    		depChartBorder.setCenter(piecharview);
			piecharview.refresh();
    	}
    }
    // 메인페인에 각 뷰를 붙인다.
	BorderPane departView;
	public void setView1(BorderPane departView) {
		this.departView=departView;
		//첫 화면을 반영한다.
		debTabBorder.setCenter(departView);  
	}
	BorderPane emptvView;
	public void setView2(BorderPane emptvView) {
		this.emptvView=emptvView;
	}
	BorderPane empsearchView;
	public void setView(BorderPane empsearchView) {
		this.empsearchView=empsearchView;
	}
	BorderPane empupdateView;
	public void setView3(BorderPane empupdateView) {
		this.empupdateView=empupdateView;
	}
	PieChartController piecharview;
	public void setView4(PieChartController piecharview) {
		this.piecharview=piecharview;
	}	
	
}
